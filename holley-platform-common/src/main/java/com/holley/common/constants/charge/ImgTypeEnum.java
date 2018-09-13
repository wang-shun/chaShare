package com.holley.common.constants.charge;

public enum ImgTypeEnum {
                         HEAD_IMG(1, "userHead", "headImg_"), // 用户头像<br>
                         STATION_IMG(2, "stationImg", "stationImg_"), // 充电点(审核通过)<br>
                         STATION_TEMP_IMG(3, "stationTempImg", "stationTempImg_"), // 充电点(申请)<br>
                         BUSSINESS_TEMP_LIC(4, "bussinessTempImg", "bussinessTempLic_"), // 运营执照(未审核)<br>
                         BUSSINESS_TEMP_COR(5, "bussinessTempImg", "bussinessTempCor_"), // 法人身份证(未审核) <br>
                         BUSSINESS_TEMP_TRAN(6, "bussinessTempImg", "bussinessTempTran_"), // 操作人身份证(未审核) <br>
                         BUSSINESS_LIC(7, "bussinessImg", "bussinessLic_"), // 运营执照(审核通过)<br>
                         BUSSINESS_COR(8, "bussinessImg", "bussinessCor_"), // 法人身份证(审核通过)<br>
                         BUSSINESS_TRAN(9, "bussinessImg", "bussinessTran_"), // 操作人身份证(审核通过) <br>
                         USER_CARD_FRONT_TEMP(10, "userCardTempImg", "userCardFrontTemp_"), // 个人实名正面身份证图片（申请）<br>
                         USER_CARD_FRONT(11, "userCardImg", "userCardFront_"), // 个人实名正面身份证图片（审核通过）<br>
                         USER_DRIVING_LICENSE(12, "userDrivingLicenseImg", "userDringLicense_"), // 行驶证图片名称 <br>
                         USER_SUGGESTION(13, "userSuggestionImg", "userSuggestion_"), // 用户意见反馈图片
                         PILE_COMMENT(14, "pileCommentImg", "pileComment_");// 充电桩评论图片

    private final int    value;
    private final String filepath;// 文件夹名称
    private final String filename;// 文件名称前缀

    ImgTypeEnum(int value, String filepath, String filename) {
        this.value = value;
        this.filepath = filepath;
        this.filename = filename;
    }

    public int getValue() {
        return value;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getFilename() {
        return filename;
    }

}
