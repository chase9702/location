package com.carrotins.backend.repository.plug

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import com.carrotins.backend.utils.transformNullToEmptyString


@Repository
class PlugStatisticsRepository(
    private val hiveJdbcTemplate: JdbcTemplate
) {
    fun getFirmwareVersionInfoData(deviceModel: String): List<FirmwareVersionInfo> {
        val query: String = if (deviceModel == "TOTAL") {
            firmwareVersionQuery
        } else {
            "$firmwareVersionQuery\nWHERE dvc_mdl = '$deviceModel'"
        }

        return hiveJdbcTemplate.query(query) { rs, _ ->
            FirmwareVersionInfo(
                bsDt = transformNullToEmptyString(rs.getString("bs_dt")),
                dvcMdl = transformNullToEmptyString(rs.getString("dvc_mdl")),
                firmwareVersion = transformNullToEmptyString(rs.getString("fota_ver_vl")),
                sumFirmwareVersion = rs.getInt("fota_ver_cnt"),
            )
        }
    }

    companion object {
        val firmwareVersionQuery = """
             SELECT 
                 bs_dt,
                 dvc_mdl,
                 fota_ver_vl,
                 fota_ver_cnt
               FROM DW.LI_PLUG_FOTA_VER
               ORDER BY bs_dt
        """.trimIndent()
    }

    fun getZeroGpsTripMonthlyInfoData(): List<ZeroGpsTripMonthlyInfo> {
        val query: String = """
             SELECT 
                 bs_dt,
                 dvc_gb,
                 dvc_mdl,
                 sum_total_trip_cnt,
                 sum_01_trip_cnt,
                 sum_03_trip_cnt,
                 sum_03_trip_rt
               FROM DW.LI_PLUG_ZERO_TRIP_MNTHLY_RSLT
               ORDER BY bs_dt

        """.trimIndent()

        hiveJdbcTemplate.fetchSize = 10000

        return hiveJdbcTemplate.query(query){ rs, _ ->
            ZeroGpsTripMonthlyInfo(
                bsDt = transformNullToEmptyString(rs.getString("bs_dt")),
                dvcGb = transformNullToEmptyString(rs.getString("dvc_gb")),
                dvcMdl = transformNullToEmptyString(rs.getString("dvc_mdl")),
                sumTotalTripCnt = rs.getInt("sum_total_trip_cnt"),
                sumNormalTripCnt = rs.getInt("sum_01_trip_cnt"),
                sumZeroTripCnt = rs.getInt("sum_03_trip_cnt"),
                sumZeroTripRt = rs.getDouble("sum_03_trip_rt"),
            )
        }
    }
    fun getZeroGpsTripDailyInfoData(): List<ZeroGpsTripDailyInfo> {
        val query: String = """
             SELECT 
                 bs_dt,
                 dvc_gb,
                 dvc_mdl,
                 sum_total_trip_cnt,
                 sum_01_trip_cnt,
                 sum_03_trip_cnt,
                 SUM_03_360_TRIP_CNT,
                 SUM_03_420_TRIP_CNT,
                 SUM_03_480_TRIP_CNT,
                 SUM_03_540_TRIP_CNT,
                 SUM_98_600_TRIP_CNT,
                 SUM_98_900_TRIP_CNT,
                 SUM_98_1200_TRIP_CNT,
                 SUM_98_1500_TRIP_CNT,
                 SUM_98_1800_TRIP_CNT,
                 SUM_98_1800_OVER_TRIP_CNT,
                 sum_03_trip_rt
               FROM DW.LI_PLUG_ZERO_TRIP_DILY_RSLT
               ORDER BY bs_dt

        """.trimIndent()

        return hiveJdbcTemplate.query(query){ rs, _ ->
            ZeroGpsTripDailyInfo(
                bsDt = transformNullToEmptyString(rs.getString("bs_dt")),
                dvcGb = transformNullToEmptyString(rs.getString("dvc_gb")),
                dvcMdl = transformNullToEmptyString(rs.getString("dvc_mdl")),
                sumTotalTripCnt = rs.getInt("sum_total_trip_cnt"),
                sumNormalTripCnt = rs.getInt("sum_01_trip_cnt"),
                sumZeroTripCnt = rs.getInt("sum_03_trip_cnt"),
                sumZero360TripCnt = rs.getInt("sum_03_360_trip_cnt"),
                sumZero420TripCnt = rs.getInt("sum_03_420_trip_cnt"),
                sumZero480TripCnt = rs.getInt("sum_03_480_trip_cnt"),
                sumZero540TripCnt = rs.getInt("sum_03_540_trip_cnt"),
                sumZero600TripCnt = rs.getInt("sum_98_600_trip_cnt"),
                sumZero900TripCnt = rs.getInt("sum_98_900_trip_cnt"),
                sumZero1200TripCnt = rs.getInt("sum_98_1200_trip_cnt"),
                sumZero1500TripCnt = rs.getInt("sum_98_1500_trip_cnt"),
                sumZero1800TripCnt = rs.getInt("sum_98_1800_trip_cnt"),
                sumZero1800OverTripCnt = rs.getInt("sum_98_1800_over_trip_cnt"),
                sumZeroTripRt = rs.getDouble("sum_03_trip_rt"),
            )
        }
    }

    fun getInterpolationTripMonthlyInfoData(): List<InterpolationTripMonthlyInfo> {
        val query: String = """
             select DVC_GB
                    ,DVC_MDL
                    ,BS_DT
                    ,DIVC_CNT
                    ,SUM_TOTAL_DIST
                    ,SUM_01_DIST
                    ,SUM_02_DIST
                    ,SUM_02_DIST_RT
                    ,SUM_TOTAL_TRIP_CNT
                    ,SUM_01_TRIP_CNT
                    ,SUM_02_TRIP_CNT
                    ,SUM_02_TRIP_RT
               FROM DW.LI_PLUG_INTP_MTHLY_RSLT
               ORDER BY bs_dt
        """.trimIndent()

        hiveJdbcTemplate.fetchSize = 10000

        return hiveJdbcTemplate.query(query){ rs, _ ->
            InterpolationTripMonthlyInfo(
                dvcGb = transformNullToEmptyString(rs.getString("dvc_gb")),
                dvcMdl = transformNullToEmptyString(rs.getString("dvc_mdl")),
                bsDt = transformNullToEmptyString(rs.getString("bs_dt")),
                dvcCnt = rs.getInt("divc_cnt"),
                sumTotalDist = rs.getInt("sum_total_dist"),
                sumNormalDist = rs.getInt("sum_01_dist"),
                sumInterpolationDist = rs.getInt("sum_02_dist"),
                distInterpolationRt = rs.getDouble("sum_02_dist_rt"),
                sumTotalTripCnt = rs.getInt("sum_total_trip_cnt"),
                sumNormalTripCnt = rs.getInt("sum_01_trip_cnt"),
                sumInterpolationTripCnt = rs.getInt("sum_02_trip_cnt"),
                sumInterpolationTripRt = rs.getDouble("sum_02_trip_rt"),
            )
        }
    }

    fun getInterpolationTripDailyInfoData(): List<InterpolationTripDailyInfo> {
        val query: String = """
             select DVC_GB
                    ,DVC_MDL
                    ,BS_DT
                    ,DIVC_CNT
                    ,SUM_TOTAL_DIST
                    ,SUM_01_DIST
                    ,SUM_02_DIST
                    ,SUM_02_DIST_RT
                    ,SUM_TOTAL_TRIP_CNT
                    ,SUM_01_TRIP_CNT
                    ,SUM_02_TRIP_CNT
                    ,SUM_02_TRIP_RT
                    ,SUM_02_TRIP_CNT_1
                    ,SUM_02_TRIP_CNT_2
                    ,SUM_02_TRIP_CNT_3
                    ,SUM_02_TRIP_CNT_5
                    ,SUM_02_TRIP_CNT_7
                    ,SUM_02_TRIP_CNT_10
                    ,SUM_02_TRIP_CNT_10_OVER
               FROM DW.LI_PLUG_INTP_RSLT
               ORDER BY bs_dt
        """.trimIndent()

        hiveJdbcTemplate.fetchSize = 10000

        return hiveJdbcTemplate.query(query){ rs, _ ->
            InterpolationTripDailyInfo(
                dvcGb = transformNullToEmptyString(rs.getString("dvc_gb")),
                dvcMdl = transformNullToEmptyString(rs.getString("dvc_mdl")),
                bsDt = transformNullToEmptyString(rs.getString("bs_dt")),
                dvcCnt = rs.getInt("divc_cnt"),
                sumTotalDist = rs.getInt("sum_total_dist"),
                sumNormalDist = rs.getInt("sum_01_dist"),
                sumInterpolationDist = rs.getInt("sum_02_dist"),
                distInterpolationRt = rs.getDouble("sum_02_dist_rt"),
                sumTotalTripCnt = rs.getInt("sum_total_trip_cnt"),
                sumNormalTripCnt = rs.getInt("sum_01_trip_cnt"),
                sumInterpolationTripCnt = rs.getInt("sum_02_trip_cnt"),
                tripInterpolationRt = rs.getDouble("sum_02_trip_rt"),
                tripCnt1 = rs.getInt("sum_02_trip_cnt_1"),
                tripCnt2 = rs.getInt("sum_02_trip_cnt_2"),
                tripCnt3 = rs.getInt("sum_02_trip_cnt_3"),
                tripCnt5 = rs.getInt("sum_02_trip_cnt_5"),
                tripCnt7 = rs.getInt("sum_02_trip_cnt_7"),
                tripCnt10 = rs.getInt("sum_02_trip_cnt_10"),
                tripCnt10Over = rs.getInt("sum_02_trip_cnt_10_over"),
            )
        }
    }
}