/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datatransferwork.demos.web;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.sql.Date;
import java.time.LocalDate;


/**
 * @author
 */
@Data
public class PushOaUserVO {

    public static final String DOCUMENT_TYPE_ID = "身份证";

    public static final String NATIONALITY_ID = "中国";

    @ApiModelProperty(value = "人员唯一标识")
    private String unicode;

    @ApiModelProperty(value = "人员编码（手机号）")
    private String staffCode;

    @ApiModelProperty(value = "人员姓名")
    private String staffName;

    @ApiModelProperty(value = "对象的证件类型")
    private String documentTypeId;

    @ApiModelProperty(value = "证件号")
    private String documentNumber;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "性别")
    private String genderId;

    @ApiModelProperty(value = "民族")
    private String nationId;

    @ApiModelProperty(value = "政治面貌")
    private String politicCountenanceId;

    @ApiModelProperty(value = "国籍")
    private String nationalityId;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "出生地")
    private String birthPlace ;

    @ApiModelProperty(value = "全日制教育学历")
    private String educationalId;

    @ApiModelProperty(value = "全日制教育学位")
    private String degreeId;

    @ApiModelProperty(value = "在职教育学历")
    private String onJobEducationId;

    @ApiModelProperty(value = "在职教育学位")
    private String onJobDegreeId;

    @ApiModelProperty(value = "婚姻状态")
    private String maritalStatusId;

    @ApiModelProperty(value = "健康状态")
    private String healthCondition;

    @ApiModelProperty(value = "毕业学校")
    private String def2;

    @ApiModelProperty(value = "专业")
    private String def3;

    @ApiModelProperty(value = "专业技术职务")
    private String technicalPosition;

    @ApiModelProperty(value = "聘任时间")
    private String technicalPositionDate;

    @ApiModelProperty(value = "聘期")
    private String appointmentTerm;

    @ApiModelProperty(value = "职业资格")
    private String professionalQualification;

    @ApiModelProperty(value = "职业资格取得时间")
    private String professionalQualificationDate;

    @ApiModelProperty(value = "参加工作时间")
    private Date workTime;

    @ApiModelProperty(value = "专业技术资格")
    private String technicalQualification;

    @ApiModelProperty(value = "取得时间")
    private String technicalQualificationDate;

    @ApiModelProperty(value = "社会工龄")
    private Integer socialWorkAge;

    @ApiModelProperty(value = "联系电话")
    private String telephone;

    @ApiModelProperty(value = "入党时间")
    private Date joinPartyTime;

    @ApiModelProperty(value = "入伍时间")
    private String participationTime;

    @ApiModelProperty(value = "退伍时间")
    private String def16;

    @ApiModelProperty(value = "单位名称")
    private String companyNameId;

    @ApiModelProperty(value = "所属集团")
    private String companyGroup;

    @ApiModelProperty(value = "入职类型")
    private String entryJobType;

    @ApiModelProperty(value = "本单位入职时间")
    private Date companyInitiationTime;

    @ApiModelProperty(value = "部门名称")
    private String departmentNameId;

    @ApiModelProperty(value = "工作电话")
    private String workPhone;

    @ApiModelProperty(value = "管理类别")
    private String managementCategoryId;

    @ApiModelProperty(value = "编制类型")
    private String compilationTypeId;

    @ApiModelProperty(value = "人员类型")
    private String staffTypeId;

    @ApiModelProperty(value = "人员类别")
    private String staffCategoryId;

    @ApiModelProperty(value = "职务类别")
    private String jobCategoryId;

    @ApiModelProperty(value = "职务名称")
    private String jobNameId;

    @ApiModelProperty(value = "任现职时间")
    private String currentJobTime;

    @ApiModelProperty(value = "职等")
    private String gradePositionsId;

    @ApiModelProperty(value = "借调")
    private String seconded;

    @ApiModelProperty(value = "借入单位")
    private String borrowingUnit;

    @ApiModelProperty(value = "借入部门")
    private String borrowingDept;

    @ApiModelProperty(value = "借入岗位")
    private String borrowingPost;

    @ApiModelProperty(value = "借调开始时间")
    private String secondedStartTime;

    @ApiModelProperty(value = "借调结束时间")
    private String secondedEndTime;

    @ApiModelProperty(value = "试用开始时间")
    private String trialStartTime;

    @ApiModelProperty(value = "试用结束时间")
    private String trialEndTime;

    @ApiModelProperty(value = "实习开始时间")
    private String practiceStartTime;

    @ApiModelProperty(value = "实习结束时间")
    private Date practiceEndTime;

    @ApiModelProperty(value = "董事会成员")
    private Boolean isBoardOfDirectors;

    @ApiModelProperty(value = "董事会职务")
    private String directorshipId;

    @ApiModelProperty(value = "经理层")
    private Boolean isBusinessLeadership;

    @ApiModelProperty(value = "是否混岗")
    private Boolean isMixing;

    @ApiModelProperty(value = "混岗单位")
    private String mixingWorkUnit;

    @ApiModelProperty(value = "技术资格等级")
    private String technologyLevel;

    @ApiModelProperty(value = "专业技术职称等级")
    private String titleLevel;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否在职")
    private String currentWorkStatus;

    public PushOaUserVO() {
        this.documentTypeId = DOCUMENT_TYPE_ID;
        this.nationalityId = NATIONALITY_ID;
        this.companyGroup = "浙江你发我发有限公司";
    }



}

