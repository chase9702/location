package com.carrotins.backend.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

/**
 * Created by alvin on 2023/07/19.
 */
@Repository
class HiveTestRepository(
    private val hiveJdbcTemplate: JdbcTemplate
) {
    fun getTestData(

    ): List<HiveDataTable> {
        val query: String = """
             SELECT 
                 COL1,
                 COL2
             FROM `test`.`tab1`
             WHERE 1=1
             LIMIT 100
        """.trimIndent()

        return hiveJdbcTemplate.query(query){ rs, _ ->
            HiveDataTable(
                col = rs.getInt("COL1"),
                type = rs.getString("COL2"),
            )
        }
    }

    fun getTestData2(

    ): List<HiveDataTable> {
        val query: String = """
             SELECT 
                 ctmno,
                 ctm_dscno
             FROM `dmp`.`cus_mstr`
             WHERE 1=1 
             LIMIT 100
        """.trimIndent()

        return hiveJdbcTemplate.query(query){ rs, _ ->
            HiveDataTable(
                col = rs.getInt("ctmno"),
                type = rs.getString("ctm_dscno"),
            )
        }
    }
}