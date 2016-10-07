package com.vgunnu

import java.sql.{ Connection, DriverManager, ResultSet };

object VgunnuApp {

  def main(args: Array[String]) {

    println("Lines with val: %s".format(121))

    // Change to Your Database Config
    val conn_str = "jdbc:drill:zk=localhosts"

    // Load the driver
    Class.forName("org.apache.drill.jdbc.Driver")

    // Setup the connection
    val conn = DriverManager.getConnection(conn_str)
    try {
      // Configure to be Read Only
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

      // Execute Query
      val rs = statement.executeQuery("select employee_id,first_name,last_name from cp.`employee.json`")

      // Iterate Over ResultSet
      while (rs.next) {
        println(rs.getInt("employee_id") + " | " + rs.getString("first_name") + " | " + rs.getString("last_name"))
      }
    } finally {
      conn.close
    }

  }

}