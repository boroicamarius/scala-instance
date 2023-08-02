package com.scaladocker

import org.flywaydb.core.Flyway

import java.sql.Connection

object Main {

    def main(args: Array[String]) {

        var driver = "org.postgresql.Driver"
        //        var url = sys.env("PG_URL")
        //        var username = sys.env("PG_USERNAME")
        //        var password = sys.env("PG_PASSWORD")

        var url = "jdbc:postgresql://localhost/access_point"
        var username = "scala"
        var password = "passwordforscala"

        println("DRIVER: " + driver)
        println("PG_URL: " + url)
        println("PG_USERNAME: " + username)
        println("PG_PASSWORD: " + password)

        // there's probably a better way to do this
        var connection: Connection = null

        try {
            //            // make the connection
            //            Class.forName(driver)
            //            println("GATHERED driver")
            //            println(driver)
            //            connection = DriverManager.getConnection(url, username, password)
            //            println("MADE connection")
            //            // create the statement, and run the select query
            //            val statement = connection.createStatement()
            //            val resultSet = statement.executeQuery("SELECT * FROM flag")
            //            while ( resultSet.next() ) {
            //                val flag_id = resultSet.getString("id")
            //                println(s"flag{id: ${flag_id}}")
            //            }

            val flyway = Flyway.configure().dataSource(url, username, password)
              .locations("classpath:db/migration").load()

            flyway.baseline()
            flyway.migrate()

        } catch {
            case e => e.printStackTrace
        }
        if (connection != null) connection.close()
    }

}
