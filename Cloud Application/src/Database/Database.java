/*
 * @Copyrights 2014
 * Authors : Melina Rousia
 * 		     Savvas Rostantis
 * 		     Marios Gavriil
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Settings.Settings;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReadWriteLock;


public class Database {
	private static Database instance = null;
	private Connection conn;
	private static Settings sett = Settings.getInstance();
	private ReadWriteLock rwlock = new ReentrantReadWriteLock();

	private Database() {
		Statement state = null;
		String query;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + sett.getIp() + ":"
					+ sett.getPort();
			conn = DriverManager.getConnection(connectionURL,
					sett.getUsername(), sett.getPassword());
			state = conn.createStatement();
			query = "CREATE DATABASE IF NOT EXISTS sdi1000132";
			state.executeUpdate(query);
		} catch (ClassNotFoundException | SQLException err) {
			err.printStackTrace();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + sett.getIp() + ":"
					+ sett.getPort() + "/" + sett.getDatabase();
			conn = DriverManager.getConnection(connectionURL,
					sett.getUsername(), sett.getPassword());
			state = conn.createStatement();

			query = "CREATE TABLE IF NOT EXISTS LOGIN ("
					+ "username VARCHAR(30)," + "password VARCHAR(30),"
					+ "PRIMARY KEY (username)" + ")";
			state.executeUpdate(query);
			query = "CREATE TABLE IF NOT EXISTS GPS ("
					+ "id int NOT NULL AUTO_INCREMENT," + "name VARCHAR(30),"
					+ "x REAL," + "y REAL, " + "PRIMARY KEY (id)" + ")";
			state.execute(query);
			query = "CREATE TABLE IF NOT EXISTS POI ("
					+ "id int NOT NULL AUTO_INCREMENT," + "name VARCHAR(30),"
					+ "type VARCHAR (30)," + "PRIMARY KEY (id) " + ")";
			state.executeUpdate(query);
			query = "CREATE TABLE IF NOT EXISTS FUNCSTATS ("
					+ "id int NOT NULL AUTO_INCREMENT, "
					+ "FUNCTION VARCHAR(255), " + "TIMESTAMP INTEGER, "
					+ "USERNAME VARCHAR(255), " + "X INTEGER , Y INTEGER ,"
					+ "PRIMARY KEY (id)" + ")";
			state.executeUpdate(query);
			query = "CREATE TABLE IF NOT EXISTS UPOI ("
					+ "id int NOT NULL AUTO_INCREMENT, "
					+ "USERNAME VARCHAR(255), " + "NUMPOI INTEGER, "
					+ "PRIMARY KEY (id) )";
			state.executeUpdate(query);
			query = "CREATE TABLE IF NOT EXISTS UPOI ("
					+ "id int NOT NULL AUTO_INCREMENT, "
					+ "USERNAME VARCHAR(255), " + "NUMPOI INTEGER, "
					+ "PRIMARY KEY (id) )";
			state.executeUpdate(query);
		} catch (ClassNotFoundException | SQLException err) {
			err.printStackTrace();
		}finally{
			if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }    
		}
	}
	
	
	

	/*
	 * return instance to database
	 */

	public static synchronized Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	
	

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	

	/*
	 * adds a user in the database , if he doesn't already exist
	 */

	public String addUser(String username, String password) {
		Statement state = null;
		rwlock.writeLock().lock();
		try {
			String query = "INSERT INTO LOGIN " + "(username,password)"
					+ "VALUES ('" + username + "','" + password + "')";
			state = conn.createStatement();
			state.executeUpdate(query);
		} catch (SQLException err) {
			err.printStackTrace();
		}finally{
			if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
			rwlock.writeLock().unlock();
		}  
		return "yes";

	}
	
	
	

	/*
	 * check if the username already exists in the database and returns the
	 * proportionate value
	 */

	public String checkUser(String username) {

		int t = 0;
		ResultSet rs = null;
		Statement state = null;
		rwlock.readLock().lock();
		try {
			String query = "SELECT USERNAME FROM LOGIN WHERE USERNAME='"
					+ username + "'";
			state = conn.createStatement();
			rs = state.executeQuery(query);
			if (!rs.next()) {
				t = 0;
			} else {
				t = 1;
			}
		}catch (SQLException err) {
			err.printStackTrace();
		}finally {  
		    if(rs != null) {  
		        try {  
		            rs.close();  
		        }  
		        catch (SQLException err) {}  
		    }  
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.readLock().unlock();
		}  
		if (t == 0)
			return "no";
		else
			return "yes";
	}
	
	
	
	
	/*
	 * Check the credentials of the User and allows or not the Access in the System
	 */

	public String accessUser(String username, String password) {
		int flag = 0;
		String po = "";
		rwlock.readLock().lock();
		try {
			Statement state = null;
			ResultSet rs = null;
			String query = "SELECT USERNAME FROM LOGIN WHERE USERNAME='"
					+ username + "'";
			state = conn.createStatement();
			rs = state.executeQuery(query);
			if (!rs.next()) {
				flag = 0;
			} else {
				flag = 1;
				query = "SELECT PASSWORD FROM LOGIN WHERE USERNAME='"
						+ username + "'";
				state = conn.createStatement();
				rs = state.executeQuery(query);
				if (rs.next())
					po = rs.getString("password");
				if (!password.equals(po)) {
					flag = 3;
				}
			}
			state.close();
			rs.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally{
			rwlock.readLock().unlock();
		}
		if (flag == 0) {
			return "no";
		} else if (flag == 1) {
			return "yes";
		} else {
			return "maybe";
		}
	}

	
	
	
	
	/*
	 * Checks and returns the POIs, that are in a specific area 
	 */
	
	
	public String getPoi(String x, String y) {

		int flag = 0;
		int flag1 = 0;
		float xaxis = Float.parseFloat(x);
		float yaxis = Float.parseFloat(y);
		StringBuilder mitsos = new StringBuilder();
		Statement state = null;
		ResultSet rs = null;
		rwlock.readLock().lock();
		try {
			state = conn.createStatement();
			String query = "SELECT *" + " FROM GPS JOIN POI "
					+ "ON POI.ID=GPS.ID " + "WHERE(" + "(X BETWEEN " + xaxis
					+ "-" + sett.getR() + " AND " + xaxis + "+" + sett.getR()
					+ ") AND (Y BETWEEN " + yaxis + "-" + sett.getR() + " AND "
					+ yaxis + "+" + sett.getR() + "))";
			rs = state.executeQuery(query);
			while (rs.next()) {
				if (mitsos.length() != 0) {
					mitsos.append("&");
				}
				mitsos.append(rs.getString("NAME") + "#" + rs.getString("TYPE")
						+ "#" + rs.getFloat("X") + "#" + rs.getFloat("Y"));
				flag = 1;
			}

		} catch (SQLException err) {
			err.printStackTrace();
		}finally {  
		    if(rs != null) {  
		        try {  
		            rs.close();  
		        }  
		        catch (SQLException err) {}  
		    }  
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.readLock().unlock();
		}
		if (flag == 0 && flag1 == 0) {
			return "no";
		} else {
			return mitsos.toString();
		}
	}
	
	
	
	
	
	/*
	 * Check if a POI is meeting the requirements of the system, in order to be added in the DB
	 */

	public String checkPoi(String name, String type, String x, String y) {
		float xaxis = Float.parseFloat(x);
		float yaxis = Float.parseFloat(y);
		int flag = 0;
		int flag1 = 0;
		int flag2 = 0;
		rwlock.readLock().lock();
		try {
			Statement state;
			ResultSet rs;
			String query = "SELECT NAME,TYPE FROM POI WHERE NAME = '" + name
					+ "' AND TYPE = '" + type + "'";
			state = conn.createStatement();
			rs = state.executeQuery(query);
			if (!rs.next()) {
				flag = 1;
			}
				query = "SELECT * FROM GPS WHERE X ='" + xaxis
						+ "' AND Y ='" + yaxis + "'";
				rs = state.executeQuery(query);
				if (!rs.next()) {
					flag2 = 1;
				} else {
					flag2 = 0;
				}
			query = "SELECT * FROM GPS WHERE( NAME='" + name
					+ "' AND (X BETWEEN " + xaxis + "-" + sett.getR() + " AND "
					+ xaxis + "+" + sett.getR() + ") AND (Y BETWEEN " + yaxis
					+ "-" + sett.getR() + " AND " + yaxis + "+" + sett.getR()
					+ "))";
			rs = state.executeQuery(query);
			if (!rs.next()) {
				flag1 = 1;
			} else {
				flag1 = 0;
			}
			state.close();
			rs.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally{
			rwlock.readLock().unlock();
		}
		if (((flag == 1) && ( (flag1 == 1) && (flag2==1) ) ) || (((flag ==0) && ( flag1 == 1) && (flag2 == 1)))) {
			return "yes";
		} else {
			return "no";
		}

	}
	
	
	
	/*
	 * Add the POI in the DB
	 */

	public void addPoi(String name, String type, String x, String y) {

		float xaxis = Float.parseFloat(x);
		float yaxis = Float.parseFloat(y);
		Statement state = null;
		rwlock.writeLock().lock();
		try {
			state = conn.createStatement();
			String query = "INSERT INTO POI " + "(name,type)" + " VALUES ('"
					+ name + "','" + type + "')";
			state.executeUpdate(query);
			query = "INSERT INTO GPS " + "(name,x,y)" + " VALUES ('" + name
					+ "','" + xaxis + "','" + yaxis + "')";
			state.executeUpdate(query);
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {    
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.writeLock().unlock();
		}

	}
	
	
	
	
	
	/*
	 * Deletes the specified User from the DB
	 */

	public void deleteUser(String username) {
		Statement state = null;
		try {
			state = conn.createStatement();
			String query = "DELETE FROM LOGIN WHERE USERNAME='" + username
					+ "'";
			state.executeUpdate(query);
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {    
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }   
		}

	}
	
	
	

	
	/*
	 * Add the method's name (setMonitorData) ,the timestamp , the username and the coordinates to table FUNCSTATS
	 */
	
	
	public void setAdd(String username,float x , float y) {
		Statement state = null;
		rwlock.writeLock().lock();
		try {
			state = conn.createStatement();
			long clock = System.currentTimeMillis() / 1000;
			String query = "INSERT INTO FUNCSTATS "
					+ "(FUNCTION,TIMESTAMP,USERNAME,X,Y) "
					+ "VALUES ('setMonitorData'," + clock + ",'" + username
					+ "',"+x+","+y+")";
			state.executeUpdate(query);
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {    
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.writeLock().unlock();
		}

	}
	
	
	
	
	
	/*
	 * Add the method's name (getMapData) ,the timestamp , the username and the coordinates to table FUNCSTATS
	 */

	public void getAdd(String username, float x, float y) {
		Statement state = null;
		rwlock.writeLock().lock();
		try {
			//Statement state;
			state = conn.createStatement();
			long clock = System.currentTimeMillis() / 1000;
			String query = "INSERT INTO FUNCSTATS "
					+ "(FUNCTION,TIMESTAMP,USERNAME,X,Y) "
					+ "VALUES ('getMapData'," + clock + ",'" + username + "',"
					+ x + "," + y + ")";
			state.executeUpdate(query);
			//state.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {   
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.writeLock().unlock();
		}
	}

	
	
	
	
	/*
	 * Count and represent the results of the aggregate calls of setMonitorData and getMapData from all the user between a specific time
	 */
	
	
	public int fCounter() {
		int total = 0;
		long clock = System.currentTimeMillis() / 1000;
		long tclock = clock - sett.getT();
		ResultSet rs = null;
		Statement state = null;
		rwlock.readLock().lock();
		try {
			state = conn.createStatement();
			String query = "SELECT FUNCTION FROM FUNCSTATS WHERE (TIMESTAMP BETWEEN "
					+ tclock + " AND " + clock + ")";
			rs = state.executeQuery(query);
			while (rs.next())
				total++;
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {  
		    if(rs != null) {  
		        try {  
		            rs.close();  
		        }  
		        catch (SQLException err) {}  
		    }  
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.readLock().unlock();
		}
		return total;
	}
	
	
	
	
	
	/*
	 * Count and represent the results of the aggregate calls of setMonitorData from all the user between a specific time
	 */

	public int sCounter() {
		int total = 0;
		long clock = System.currentTimeMillis() / 1000;
		long tclock = clock - sett.getT();
		ResultSet rs = null;
		Statement state = null;
		rwlock.readLock().lock();
		try {
			state = conn.createStatement();
			String query = "SELECT FUNCTION FROM FUNCSTATS WHERE ((TIMESTAMP BETWEEN "
					+ tclock
					+ " AND "
					+ clock
					+ ") AND (FUNCTION = 'setMonitorData'))";
			rs = state.executeQuery(query);
			while (rs.next())
				total++;
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {  
		    if(rs != null) {  
		        try {  
		            rs.close();  
		        }  
		        catch (SQLException err) {}  
		    }  
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.readLock().unlock();
		}
		return total;
	}
	
	
	
	
	
	/*
	 * Represent the user infos in the second tab of gui
	 */

	public String usInfo(String username) {
		int scount = 0;
		int gcount = 0;
		int nos = 0;
		int gos = 0;
		int no = 0;
		String us = "";
		String pass = "";
		String snou = "";
		String gnou = "";
		String general = "";
		rwlock.readLock().lock();
		try {
			Statement state;
			ResultSet rs;
			state = conn.createStatement();
			String query = "SELECT * FROM LOGIN WHERE USERNAME = '" + username
					+ "'";
			rs = state.executeQuery(query);
			if (rs.next()) {
				us = rs.getString("USERNAME");
				pass = rs.getString("PASSWORD");
			}

			query = "SELECT NUMPOI FROM UPOI WHERE USERNAME = '" + username
					+ "'";
			rs = state.executeQuery(query);
			if (rs.next()) {
				no = rs.getInt("NUMPOI");
			}

			query = "SELECT FUNCTION FROM FUNCSTATS WHERE ("
					+ "( FUNCTION = 'setMonitorData') AND " + "( USERNAME = '"
					+ username + "'))";
			rs = state.executeQuery(query);
			while (rs.next()) {
				nos++;
				snou = String.valueOf(nos);
			}

			query = "SELECT FUNCTION FROM FUNCSTATS WHERE FUNCTION = 'setMonitorData'";
			rs = state.executeQuery(query);
			while (rs.next())
				scount++;

			query = "SELECT FUNCTION FROM FUNCSTATS WHERE ("
					+ "( FUNCTION = 'getMapData') AND " + "( USERNAME = '"
					+ username + "'))";
			rs = state.executeQuery(query);
			while (rs.next()) {
				gos++;
				gnou = String.valueOf(gos);
			}

			query = "SELECT FUNCTION FROM FUNCSTATS WHERE FUNCTION = 'getMapData'";
			rs = state.executeQuery(query);
			while (rs.next())
				gcount++;
			state.close();
			rs.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally{
			rwlock.readLock().unlock();
		}
		general = general + "Username : " + us + "\n" + "Password : " + pass
				+ "\n\n" + "Total Pois added by user : " + no + "\n\n"
				+ "User setMonitorData / \n" + "  Overall setMonitorData : "
				+ snou + " / " + scount + "\n\n" + "User getMapData / \n "
				+ "  Overall getMapData : " + gnou + " / " + gcount + "\n";
		return general;
	}
	
	
	
	
	
	/*
	 * Insert the number of POIs each user has added in the DB
	 */

	public void apu(String username) {
		Statement state = null;
		rwlock.writeLock().lock();
		try {
			state = conn.createStatement();
			String query = "INSERT INTO UPOI (username,numpoi) VALUES ('"
					+ username + "',0)";
			state.executeUpdate(query);
			state.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {   
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.writeLock().unlock();
		}
	}

	
	
	
	
	/*
	 * Updates the number of POIs each user has added in the DB
	 */
	
	public void update(String username) {
		Statement state = null;
		rwlock.writeLock().lock();
		try {
			state = conn.createStatement();
			String query = "UPDATE UPOI SET NUMPOI = NUMPOI+1 WHERE USERNAME = '"
					+ username + "'";
			state.executeUpdate(query);
			state.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {  
		    if(state != null) {  
		        try {  
		            state.close();  
		        }  
		        catch (SQLException err) {}  
		    }
		    rwlock.writeLock().unlock();
		}
	}
	
	
	
	
	
	/*
	 * Shows the infos of the setMonitorData and getMapData to a specific area on gui
	 */

	public String koko(float x, float y) {
		String xy;
		int sgcount = 0;
		int ggcount = 0;
		rwlock.readLock().lock();
		try {
			Statement state;
			ResultSet rs;
			state = conn.createStatement();
			String query = "SELECT USERNAME FROM FUNCSTATS " + "WHERE ((X = "
					+ x + ") AND (Y = " + y + "))";
			rs = state.executeQuery(query);
			while (rs.next())
				sgcount++;
			query = "SELECT FUNCTION FROM FUNCSTATS "
					+ "WHERE ((FUNCTION = 'getMapData') " + "AND (X BETWEEN "
					+ x + "-" + sett.getR() + " AND " + x + "+" + sett.getR()
					+ ")" + " AND (Y BETWEEN " + y + "-" + sett.getR()
					+ " AND " + y + "+" + sett.getR() + "))";
			rs = state.executeQuery(query);
			while (rs.next())
				ggcount++;
			state.close();
			rs.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally{
			rwlock.readLock().unlock();
		}
		xy = "The aggregate calls of setMonitorData \nand "
				+ "getMapData for THIS POI are : " + sgcount + "\n\n"
				+ "The aggregate calls of getMapData \n"
				+ "in this area are : " + ggcount;
		return xy;
	}

}