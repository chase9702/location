export const transFormRsValueToString = (rsValue: string) => {
    if (rsValue === "rs0_cnt") return "No Service"
    else if (rsValue === "rs1_cnt") return "Poor"
    else if (rsValue === "rs2_cnt") return "Fair"
    else return "Good"
}
export const transFormAcValueToString = (acValue: string) => {
    const acString = acValue.match(/\d+/);
    const acNumber = parseInt(acString[0], 10);
    if (acNumber === 100) return acNumber + 'M 초과'
    else if (acNumber === 0) return '1M 미만'
    else return acNumber + 'M 이하'
}

export const deviceModel = [
    {value: 'TOTAL', label: 'TOTAL'},
    {value: 'AMT1', label: 'AMT1'},
    {value: 'TLK1', label: 'TLK1'},
    {value: 'ETO1', label: 'ETO1'},
    {value: 'UNK1', label: 'UNK1'},
    {value: 'LUX1', label: 'LUX1'},
    {value: 'LUX2', label: 'LUX2'},
]

export const personalFilter = [
    {value: 'member_id', label: 'MEMBER ID'},
    {value: 'plyno', label: 'PLYNO'},
    {value: 'dvc_id', label: 'DIVC ID'},
]
export const deviceTop100Data = [
    "dvc_id",
    "plyno",
    "trip_cnt",
    "lag_mean",
    "lag_std",
    "lag_min",
    "lag_max",
    "fix_vld_gps_elapsed_time_mean",
    "fix_vld_gps_elapsed_time_std",
    "fix_vld_gps_elapsed_time_min",
    "fix_vld_gps_elapsed_time_max",
    "vld_ideal_cnt_sum",
    "ideal_cnt_sum",
    "rcv_data_cnt_sum",
    "invld_gps_cnt_sum",
    "rcv_lag_time_sum",
    "cr_prd_cmpcd_nm",
    "zero_trip_cnt",
    "zero_trip_ratio",
    "ver",
    "tp_mean",
    "tp_std",
    "tp_min",
    "tp_max",
    "tp_nullcnt",
    "vx_mean",
    "vx_std",
    "vx_min",
    "vx_max",
    "vx_nullcnt",
    "vi_mean",
    "vi_std",
    "vi_min",
    "vi_max",
    "vi_nullcnt",
    "rs_0_cnt",
    "rs_1_cnt",
    "rs_2_cnt",
    "rs_3_cnt",
    "ac_0_cnt",
    "ac_1_cnt",
    "ac_2_cnt",
    "ac_3_cnt",
    "ac_5_cnt",
    "ac_7_cnt",
    "ac_9_cnt",
    "ac_14_cnt",
    "ac_19_cnt",
    "ac_24_cnt",
    "ac_29_cnt",
    "ac_39_cnt",
    "ac_59_cnt",
    "ac_69_cnt",
    "ac_99_cnt",
    "ac_100_cnt",
    "invld_gps_cnt_ratio",
    "invld_rcv_lag_time_ratio",
    "part_dt"
]

export const deviceTripData = [
    "plyno",
    "dvc_id",
    "trip_id",
    "ver",
    "lag",
    "rcv_data_cnt",
    "start_tr_ct",
    "end_tr_ct",
    "invld_gps_cnt",
    "rcv_lag_time",
    "tp_mean",
    "tp_std",
    "tp_min",
    "tp_max",
    "tp_nullcnt",
    "vx_mean",
    "vx_std",
    "vx_min",
    "vx_max",
    "vx_nullcnt",
    "vi_mean",
    "vi_std",
    "vi_min",
    "vi_max",
    "vi_nullcnt",
    "rs_0_cnt",
    "rs_1_cnt",
    "rs_2_cnt",
    "rs_3_cnt",
    "ac_0_cnt",
    "ac_1_cnt",
    "ac_2_cnt",
    "ac_3_cnt",
    "ac_5_cnt",
    "ac_7_cnt",
    "ac_9_cnt",
    "ac_14_cnt",
    "ac_19_cnt",
    "ac_24_cnt",
    "ac_29_cnt",
    "ac_39_cnt",
    "ac_59_cnt",
    "ac_69_cnt",
    "ac_99_cnt",
    "ac_100_cnt",
    "fix_vld_gps_elapsed_time",
    "vld_ideal_cnt",
    "ideal_cnt",
    "invld_gps_ratio",
    "invld_rcv_lag_time_ratio",
    "trip_gb",
    "cr_prd_cmpcd_nm",
    "part_dt"
]

export const boxPlotField = ['max', 'mean+1std' , 'mean', 'mean-1std', 'min' ]