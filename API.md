# 业务数据服务接口定义

## 一、API 接口列表

> BASE URL：`/api/v1`

| 接口分类 | 序号 | 方法 | 接口 | 接口描述 |
| ------ | -----| --- | --- | ------- |
| 通⽤业务服务 | 1.1 | GET | `/common/person/info` | 获取个人基本信息 |
| 通⽤业务服务 | 1.2 | GET | `/common/person/contacts` | 获取联系人信息 |
| 通⽤业务服务 | 1.3 | GET | `/common/person/telephone` | 获取联系电话 |
| 通⽤业务服务 | 1.4 | GET | `/common/person/search-persons` | 获取符合搜索条件的人员信息列表 |
| 通⽤业务服务 | 1.5 | GET | `/common/medical-organization/infos/query` | 批量获取定点医疗机构信息 |
| 通⽤业务服务 | 1.6 | GET | `/common/visit-record/info` | 获取单次就诊的就诊信息（包括患者索引信息） |
| 医疗健康业务服务 | 2.1 | GET | `/health/person/diseases` | 获取个人病史 |
| 医疗健康业务服务 | 2.2 | GET | `/health/person/medical-records` | 获取个人就诊履历 |
| 医疗健康业务服务 | 2.3 | GET | `/health/person/med/tests` | 获取就诊的检验记录 |
| 医疗健康业务服务 | 2.4 | GET | `/health/person/med/examinations` | 获取就诊的检查记录 |
| 医疗健康业务服务 | 2.5 | GET | `/health/person/med/advices` | 获取就诊的医嘱信息 |
| 医疗健康业务服务 | 2.6 | GET | `/health/person/med/operations` | 获取就诊的手术信息 |
| 医疗健康业务服务 | 2.7 | GET | `/health/person/med/drugs` | 获取就诊的用药信息 |
| 医疗健康业务服务 | 2.8 | GET | `/health/person/med/clinic-items` | 获取就诊的诊疗项目信息 |
| 医疗健康业务服务 | 2.9 | GET | `/health/person/med/homepage-base` | 获取就诊的病案首页的基本信息 |
| 医疗健康业务服务 | 2.10 | GET | `/health/person/med/homepage-fee` | 获取就诊的病案首页中费用信息 |
| 医疗健康业务服务 | 2.11 | GET | `/health/person/med/summary` | 获取就诊的出院小结信息 |
| 医疗健康业务服务 | 2.12 | GET | `/health/person/med/homepage-diagnoses` | 获取就诊的电子病历首页中诊断信息 |
| 医疗健康业务服务 | 2.13 | GET | `/health/person/med/homepage-operations` | 获取就诊的电子病历首页中手术信息 |
| 医疗健康业务服务 | 2.14 | GET | `/health/person/med/homepage` | 获取住院病案首页 |
| 医疗健康业务服务 | 2.15 | GET | `/health/person/inpatient-records` | 获取个人的住院明细一览 |
| 医疗健康业务服务 | 2.16 | GET | `/health/person/outpatient-records` | 获取个人的门诊就诊明细一览 |
| 医疗健康业务服务 | 2.17 | GET | `/health/person/medical-record` | 获取单次就诊所有明细信息 |
| 保险业务服务 | 3.1 | GET | `/insurance/person/insurant` | 获取个人参保信息最后一条有效记录 |
| 保险业务服务 | 3.2 | GET | `/insurance/person/balance` | 获取个人医保账户余额 |
| 保险业务服务 | 3.3 | GET | `/insurance/person/pay-journal` | 获取医保就诊赔付信息 |
| 保险业务服务 | 3.4 | GET | `/insurance/person/pay-detail` | 获取医保就诊付费明细信息 |
| 保险业务服务 | 3.5 | GET | `/insurance/person/visit-pay-journal` | 获取医保就诊赔付的明细信息 |
| 保险业务服务 | 3.6 | GET | `/insurance/person/insurants` | 获取个人参保信息 |
| 保险业务服务 | 3.7 | GET | `/insurance/person/info` | 获取指定医保号的参保人员信息 |
| 文件服务 | 4.1 | GET | `/file/person/photo` | 获取个人照片 |
| 药店服务 | 5.1 | GET | `/store/person/drugs` | 获取个人历史购药记录详细信息 |
| 药店服务 | 5.2 | GET | `/store/person/drugRecords` | 获取个人历史购药记录 |

## 二、接口描述

### 1. 通用业务服务

#### 1.1. 获取个人基本信息

通过证件类型、证件号码和姓名，获取此人的基本信息，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/common/person/info`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
    "idTypeCode": "string",     <-- 证件类型代码
    "idTypeName": "string",     <-- 证件类型名称
    "idCardNo": "string",       <-- 证件号码
    "name": "string",           <-- 姓名
    "gender": "string",         <-- 性别
    "age": 0,                   <-- 年龄，数值类型，例：68
    "birthday": "date",         <-- 出生日期，日期类型，例：2018-01-22
    "birthplace": "string",     <-- 出生地                    
	"aboBlood": "string",       <-- ABO血型
    "rhBlood": "string",        <-- RH血型
    "allergy": "string",        <-- 过敏药品
    "nation": "string",         <-- 民族
    "country": "string",        <-- 国籍
    "marriage": "string",       <-- 婚姻状况
    "education": "string",      <-- 文化程度
    "occupation": "string",     <-- 职业                        	
    "address": "string",        <-- 家庭住址
    "telephone": "string",      <-- 联系电话
    "death": false,             <-- 是否死亡，true：死亡；false：正常
    "deathDate": "date",        <-- 死亡日期，日期类型，例：2018-01-22
    "deathHospital": "string",  <-- 死亡医院
    "deathplace": "string",     <-- 死亡地点
    "deathReason": "string"     <-- 死亡原因
}
```

#### 1.2. 获取联系人信息

通过证件类型、证件号码和姓名，获取此人的联系人的信息，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/common/person/contacts`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
    {
      "name": "string",         <-- 联系人姓名
      "telephone": "string",    <-- 联系人电话
      "address": "string",      <-- 联系人地址
      "relationship": "string", <-- 联系人与此人的关系
    },
    ...                         <-- 其他联系人
]
```
#### 1.3. 获取联系电话

通过证件类型、证件号码，获取此人的联系电话。

**URL** : `/api/v1/common/person/telephone`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |


**返回数据**

> HTTP状态码：200
> HTTP内容：电话号码




#### 1.4. 获取符合搜索条件的人员信息列表

通过（证件号），（电话号码），（姓名，基础属性{血型，年龄，性别，民族，婚姻，职业}，患病，就诊医院）获取相关人员的列表，存在分页功能

**URL** : `/api/v1/common/person/search-persons`

**Method** : `POST`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **id_no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **id_type** | _string_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **telephone** | _string_ | **是** | - | **电话号码**，例：`13941302011` |
| **diagnosis_code** | _string_ | **是** | - | **患病编码**，例：`A16.202` |
| **hospital_no** | _string_ | **是** | - | **就诊医院编码**，例：`6880` |
| **abo_blood_code** | _string_ | **是** | - | **血型**，例：`1` |
| **gender_code** | _string_ | **是** | - | **性别**，例：`1` |
| **age_start** | _string_ | **是** | - | **起始年龄**，例：`20` |
| **age_end** | _string_ | **是** | - | **终止年龄**，例：`10` |
| **nation_code** | _string_ | **是** | - | **民族**，例：`1` |
| **marital_status_code** | _string_ | **是** | - | **婚姻**，例：`1` |
| **occupation_code** | _string_ | **是** | - | **职业**，例：`1` |
| **page_nunber** | _string_ | **是** | - | **页码**，例：`1` |
| **page_size** | _string_ | **是** | - | **每页记录数量**，例：`10` 缺省为中国居民身份证，值为 `10` |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
{
    "idTypeCode": "string",     <-- 证件类型代码
    "idTypeName": "string",     <-- 证件类型名称
    "idCardNo": "string",       <-- 证件号码
    "name": "string",           <-- 姓名
    "gender": "string",         <-- 性别
    "age": 0,                   <-- 年龄，数值类型，例：68
    "birthday": "date",         <-- 出生日期，日期类型，例：2018-01-22
    "birthplace": "string",     <-- 出生地                    
	"aboBlood": "string",       <-- ABO血型
    "rhBlood": "string",        <-- RH血型
    "allergy": "string",        <-- 过敏药品
    "nation": "string",         <-- 民族
    "country": "string",        <-- 国籍
    "marriage": "string",       <-- 婚姻状况
    "education": "string",      <-- 文化程度
    "occupation": "string",     <-- 职业                        	
    "address": "string",        <-- 家庭住址
    "telephone": "string",      <-- 联系电话
    "death": false,             <-- 是否死亡，true：死亡；false：正常
    "deathDate": "date",        <-- 死亡日期，日期类型，例：2018-01-22
    "deathHospital": "string",  <-- 死亡医院
    "deathplace": "string",     <-- 死亡地点
    "deathReason": "string"     <-- 死亡原因
},
...                             <--其他人员信息 
]
```

#### 1.5. 批量获取定点医疗机构信息

通过保险公司编号（或医保统筹区编号）、医疗机构编号的列表,批量获取定点医疗机构信息（忽略其中不存在医疗机构）

**URL** : `/api/v1/common/med-org/infos/query`

**Method** : `POST`

**请求RequestBody** 
```json
[
    {
        "region":"string",          <--保险公司编号（或医保统筹区编号）
        "org_no":"string"               <--医疗机构编号
    }
    ...                             <--其他查询   
]
```

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "code":"string",        <--医疗机构编号
  	"name":"string",        <--医疗机构名称	
  	"address":"string",     <--地址			
  	"levelCd":"string",     <--医院等级代码	
  	"typeCd":"string",      <--医疗机构类别代码	
  	"chgLvlCd":"string",    <--医院收费级别代码	
  	"crdtRtCd":"string",    <--医院信用等级代码 
  	"longitude":"string",   <--地理位置经度	
  	"latitude":"string",     <--地理位置纬度 
  	"telephone":"string"    <-- 电话
  }
  ...                                   <-- 其他定点医疗机构信息
]
```

#### 1.6. 获取单次就诊的就诊信息（包括患者索引信息）

通过就诊流水号、统筹区编码、医院编码获取单次就诊信息，包括个人id等基础信息

**URL** : `/api/v1/common/visit-record/info`

**Method** : `GET`

**请求RequestBody** 
```json

{
    "region":"string",          <--保险公司编号（或医保统筹区编号）
    "hos":"string",              <--医疗机构编号
    "vno":"string"               <--就诊流水号
}

```

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
      "visitNo": "string",      <-- 就诊流水号
      "personInfoId": "string",      <-- 自然人ID
      "insuredPersonNo": "string",      <-- 参保人编号
      "idTypeCode": "string",      <-- 证件类型代码
      "idCardNo": "string",      <-- 证件号码
      "name": "string",      <-- 姓名
      "regionNo": "string",      <-- 保险公司编号
      "type": 0,                <-- 门诊/住院，1：门诊，2：住院
      "medicalKind": "string",  <-- 医疗类别
      "medicalKindCode": "string",  <-- 医疗类别编码
      "admDate": "date",        <-- 门诊的就诊日期，住院的入院日期
      "disDate": "date",        <-- 出院日期
      "medOrgName": "string",   <-- 医疗机构
      "medOrgCode":"String"		<-- 医疗机构编码
      "department": "string",   <-- 科室
      "doctor": "string",       <-- 医生
      "inHosDays": "string",    <-- 住院天数
    }
```

### 2. 医疗健康业务服务

#### 2.1. 获取个人病史

通过证件类型、证件号码和姓名，获取此人的病史，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

可以通过设置诊断日期范围条件，约束返回的结果集。

**URL** : `/api/v1/health/person/diseases`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **start** | _string_ | _否_ | `null` | **诊断日期范围（开始）**，格式：`yyyyMMdd`，条件为大于等于。 |
| **end** | _string_ | _否_ | `null` | **诊断日期范围（结束）**，格式：`yyyyMMdd`，条件为小于等于。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
    {
      "code": "string",         <-- ICD诊断编码
      "name": "string",         <-- ICD诊断名称
      "type": "string",         <-- 分类
      "category": "string",     <-- 病种
      "special": "string",      <-- 特病
      "fstCfmdDate": "string",  <-- 第一次确诊日期
      "lstCfmdDate": "string",  <-- 最后一次确诊日期
      "sources":[               <-- 诊断来源
        {
          "code":"string",      <-- 诊断类型编码 01,02,03,94,95,96
          "name":"string"       <-- 诊断类型名称 
        }
        ...
      ]
    },
    ...                         <-- 其他疾病
]
```

#### 2.2. 获取个人就诊履历

通过证件类型、证件号码和姓名，获取此人的就诊履历，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

可以通过设置入院/就诊日期范围、出院日期范围和医保统筹区编号/保险公司编号等条件，约束返回的结果集。

**URL** : `/api/v1/health/person/medical-records`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **admst** | _string_ | _否_ | `null` | **入院/就诊日期范围（开始）**，格式：`yyyyMMdd`，条件为大于等于。 |
| **admed** | _string_ | _否_ | `null` | **入院/就诊日期范围（结束）**，格式：`yyyyMMdd`，条件为小于等于。 |
| **disst** | _string_ | _否_ | `null` | **出院日期范围（开始）**，格式：`yyyyMMdd`，条件为大于等于。 |
| **dised** | _string_ | _否_ | `null` | **出院日期范围（结束）**，格式：`yyyyMMdd`，条件为小于等于。 |
| **region** | _string_ | _否_ | `null` | **医保统筹区编号/保险公司编号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
    {
      "visitNo": "string",      <-- 就诊流水号
      "type": 0,                <-- 门诊/住院，1：门诊，2：住院
      "medicalKind": "string",  <-- 医疗类别
      "medicalKindCode": "string",  <-- 医疗类别编码
      "admDate": "date",        <-- 门诊的就诊日期，住院的入院日期
      "disDate": "date",        <-- 出院日期
      "medOrgName": "string",   <-- 医疗机构
      "medOrgCode":"String"		<-- 医疗机构编码
      "medOrgLvl": "string",    <-- 医疗机构等级
      "department": "string",   <-- 科室
      "doctor": "string",       <-- 医生
      "inHosDays": "string",    <-- 住院天数
      "drgsCode": "string",     <-- DRGs分组编码
      "drgsName": "string",     <-- DRGs分组名称
      "mdcCode": "string",      <-- MDC分类编码
      "mdcName": "string",      <-- MDC分类名称
      "diagnoses": [            <-- 就诊诊断
        {
          "icdCode": "string",  <-- ICD诊断编码
          "icdName": "string",  <-- ICD诊断名称
          "isPrincipal": false, <-- 是否主诊断，true：主诊断，false：非主诊断
          "typeCode": "string",     <-- 诊断类别编码
          "typeName": "string",     <-- 诊断类别名称
          "order": 0,           <-- 诊断顺位
        },
        ...                     <-- 其他诊断结果
      ],
    },
    ...                         <-- 其他就诊记录
]
```

#### 2.3. 获取个人的就诊检验记录

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次就诊的检验信息。

**URL** : `/api/v1/health/person/med/tests`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "specNo": "string",          <-- 检验标本号
    "personName": "string",      <-- 患者姓名
    "gender": "string",          <-- 性别
    "age": "int",                <-- 年龄
    "specDt": "datetime",        <-- 接收标本的日期时间
    "specKind": "string",        <-- 标本类别
    "specStatus": "string",      <-- 标本状态
    "clinDiag": "string",        <-- 临床诊断
    "projects": [                <-- 检验
      {
        "testName": "string",    <-- 检验方法
        "testDt": "datetime",    <-- 检验日期
        "physician": "string",   <-- 检验医生
        "testNo": "string",      <-- 检验报告单编号
        "memo": "string",        <-- 检验报告备注
        "items": [               <-- 检验项目
          {
            "no": "string",      <-- 检验项目序号
            "code": "string",    <-- 检验项目代码
            "name": "string",    <-- 检验项目名称
            "result": "string",  <-- 检验结果
            "refVal": "string",  <-- 参考值
            "unit": "string",    <-- 单位
            "sign": "string",    <-- 指标异常
            "resultQualitative": "string" <-- 检验结果（定性）
          },
          ...                    <-- 其他检验项目
        ],
      },
      ...                        <-- 其他检验
    ],
  },
  ...                            <-- 其他检验报告
]
```

#### 2.4. 获取个人的就诊检查记录

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次就诊的检查信息。

**URL** : `/api/v1/health/person/med/examinations`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "appFormNo": "string",       <-- 电子申请单编号
    "specDt": "datetime",        <-- 送检日期
    "specKind": "string",        <-- 标本类别
    "specStatus": "string",      <-- 标本状态
    "specNo": "string",          <-- 检查标本号
    "examPart": "string",        <-- 检查部位
    "type": "string",            <-- 检查类型
    "complaint": "string",       <-- 主诉
    "symptom": "string",         <-- 症状描述
    "specFixative": "string",    <-- 标本固定液
    "process": "string",         <-- 诊疗过程描述
    "reportNo": "string",        <-- 检查报告单编号
    "objReport": "string",       <-- 检查报告结果-客观所见
    "subReport": "string",       <-- 检查报告结果-主观提示
    "memo": "string",            <-- 检查报告备注
    "reportDt": "datetime",      <-- 检查报告日期时间
    "itemName": "string",        <-- 检查项目名称
    "itemResult": "string",      <-- 检查项目结果
    "ultraImgReport": "string",  <-- 影像与超声检查
    "examinationPerson": "string",        <-- 审核医师
    "reportPerson": "string",      <-- 报告医师
    "clinicalDiagnosis": "string",  <-- 临床诊断
  },
  ...                            <-- 其他检查记录
]
```

#### 2.5. 获取个人的就诊医嘱信息

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次就诊的医嘱信息。

**URL** : `/api/v1/health/person/med/advices`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "adviceDt": "datetime",      <-- 下达医嘱的日期时间
    "items": [                   <-- 医嘱项目
      {
        "adviceNo": "string",    <-- 医嘱流水号      
        "code": "string",        <-- 医嘱项目编码
        "name": "string",        <-- 医嘱项目名称
        "type": "string",        <-- 医嘱项目类别
        "dose": "string",        <-- 每次用量
        "unit": "string",        <-- 剂量单位
        "total": "string",       <-- 总量
        "daily": "string",       <-- 日频次
        "freq": "string",        <-- 使用频次
        "usage": "string",       <-- 用法
        "miniDose": "string",    <-- 最小剂量
        "miniDoseUnit": "string",<-- 最小剂量单位
        "groupId": "string",     <-- 组合号
        "startDt": "datetime",   <-- 医嘱开始执行的日期时间
        "startDoctor": "string", <-- 开始医生
        "startNurse": "string",  <-- 开始护士
                
        "stopDt": "datetime",    <-- 医嘱停止的日期时间
        "stopDoctor": "string",  <-- 停止医生        
        "stopExecDt": "datetime",<-- 停止执行时间
        "stopNurse": "string",   <-- 停止护士
        "isLongAdvice": false,   <-- 是否长期医嘱，true：长期医嘱，false：一般医嘱
        "isValuation": false,    <-- 是否计价，true：计价，false：不计价
        "isInvalid": false,      <-- 医嘱是否作废，true：作废，false：正常        
      },
      ...                        <-- 其他医嘱项目
    ],
  },
  ...                            <-- 其他医嘱
]
```

#### 2.6. 获取个人的就诊手术记录

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次就诊的手术信息。

**URL** : `/api/v1/health/person/med/operations`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "no": "string",              <-- 手术编号
    "name": "string",            <-- 手术名称
    "opeDt": "datetime",         <-- 手术日期时间
    "opeLvl": "string",          <-- 手术级别
    "opePos": "string",          <-- 手术体位
    "opeHis": "string",          <-- 手术史标志
    "aob": "string",             <-- 出血量
    "aot": "string",             <-- 输血量
    "plcPos": "string",          <-- 放置部位
    "incision": "string",        <-- 手术切口描述
    "premedicate": "string",     <-- 术前用药
    "damName": "string",         <-- 引流材料名称
    "damAmount": "string",       <-- 引流材料数目
    "before": "string",          <-- 术前诊断
    "after": "string",           <-- 术后诊断
    "process": "string",         <-- 过程描述
    "anesthesia": "string",      <-- 麻醉方式
    "surgeon": "string",         <-- 手术医生
    "analgesist": "string",      <-- 麻醉师
    "assistants": "string",      <-- 手术助手
    "startTime":"string",		 <-- 手术开始时间
    "endTime":"string"		     <-- 手术结束时间
  },
  ...                            <-- 其他手术记录
]
```


#### 2.7. 获取个人的就诊用药记录

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次就诊的用药信息。

**URL** : `/api/v1/health/person/med/drugs`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "billNo": "string",          <-- 单据号
    "presNo": "string",          <-- 处方号
    "presDt": "datetime",        <-- 处方日期时间
    "categoryCode": "string",    <-- 项目类别代码
    "categoryName": "string",    <-- 项目类别名称
    "hItemCode": "string",       <-- 医院收费项目代码
    "mItemCode": "string",       <-- 付费方收费项目代码
    "name": "string",            <-- 收费项目名称
    "spec": "string",            <-- 规格     
    "amount": "double",          <-- 数量
    "unit": "string",            <-- 单位
    "price": "string",           <-- 单价
    "chargeLevel": "string",     <-- 收费项目等级
    "fee": 0,                    <-- 金额
    "manufacture": "string",     <-- 生产企业名称
    "drugApprovalNo": "string",  <-- 药品批准文号
    "otc": "string",             <-- OTC标识
    "executionTime": "string",   <-- 执行日期
  },
  ...                            <-- 其他使用药品
]
```

#### 2.8. 获取个人的就诊诊疗项目

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次就诊的诊疗项目信息。

**URL** : `/api/v1/health/person/med/clinic-items`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "billNo": "string",          <-- 单据号
    "presNo": "string",          <-- 处方号
    "presDt": "datetime",        <-- 处方日期时间
    "categoryCode": "string",    <-- 项目类别代码
    "categoryName": "string",    <-- 项目类别名称
    "hItemCode": "string",       <-- 医院收费项目代码
    "mItemCode": "string",       <-- 付费方收费项目代码
    "name": "string",            <-- 收费项目名称
    "spec": "string",            <-- 规格     
    "amount": 0,                 <-- 数量
    "unit": "string",            <-- 单位
    "price": "string",           <-- 单价
    "chargeLevel": "string",     <-- 收费项目等级
    "fee": 0,                    <-- 金额
    "manufacture": "string",     <-- 生产企业名称
    "ceilingPrice": "string",	 <-- 最高限价
  },
  ...                            <-- 其他诊疗项目
]
```

#### 2.9. 获取个人的住院病案首页

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次住院的病案首页。

**URL** : `/api/v1/health/person/med/homepage-base`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
  "medOrgName": "string",        <-- 医疗机构名称
  "orgLicNo": "string",          <-- 组织机构代码
  "paymentWay": "string",        <-- 医疗费用支付方式
  "inHosTimes": "string",        <-- 住院次数
  "healthCardNo": "string",      <-- 居民健康卡号
  "insurCardNo": "string",       <-- 医保卡号
  "visitNo": "string",           <-- 就诊流水号
  "medRecordNo": "string",       <-- 病案号
  "name": "string",              <-- 姓名
  "gender": "string",            <-- 性别
  "age": 0,                      <-- 年龄
  "birthday": "date",            <-- 出生日期
  "country": "string",           <-- 国籍
  "nativeplace": "string",       <-- 籍贯
  "nation": "string",            <-- 民族
  "ageMonths": 0,                <-- 月龄
  "birthWeight": 0,              <-- 新生儿出生体重(g)
  "admWeight": 0,                <-- 新生儿入院体重(g)
  "idType": "string",            <-- 证件类型
  "idCardNo": "string",          <-- 证件号码
  "occupation": "string",        <-- 职业类别
  "marStatus": "string",         <-- 婚姻状况
  "address": "string",           <-- 现住址
  "telephone": "string",         <-- 联系电话
  "registry": "string",          <-- 户口
  "unitName": "string",          <-- 工作单位名称
  "unitAddr": "string",          <-- 工作单位地址
  "unitPhone": "string",         <-- 工作单位电话号码
  "contName": "string",          <-- 联系人姓名
  "contAddr": "string",          <-- 联系人地址
  "contPhone": "string",         <-- 联系人电话号码
  "relationship": "string",      <-- 联系人与患者的关系
  "admWays": "string",           <-- 入院途径
  "admDate": "string",           <-- 入院日期
  "admDept": "string",           <-- 入院科室
  "admWard": "string",           <-- 入院病房
  "refDept": "string",           <-- 转科科室
  "disDate": "string",           <-- 出院日期
  "disDept": "string",           <-- 出院科室
  "disWard": "string",           <-- 出院病房
  "inHosDays": "string",         <-- 住院天数
  "clinDiagCode": "string",      <-- 门(急)诊诊断名称
  "clinDiagName": "string",      <-- 门(急)诊诊断编码
  "poisonReason": "string",      <-- 损伤中毒的外部原因
  "pathDiagCode": "string",      <-- 病理诊断编码
  "pathDiagName": "string",      <-- 病理诊断名称
  "pathologyNo": "string",       <-- 病理号
  "isAllergy": false,            <-- 是否药物过敏
  "allergyDrug": "string",       <-- 过敏药物
  "isAutopsy": false,            <-- 是否死亡患者尸检
  "aboBlood": "string",          <-- ABO血型
  "rhBlood": "string",           <-- Rh血型
  "director": "string",          <-- 科主任
  "chiefPhy": "string",          <-- 主任(副主任)医师
  "phyInCha": "string",          <-- 主治医师
  "resident": "string",          <-- 住院医师
  "prNurse": "string",           <-- 责任护士
  "trainee": "string",           <-- 进修医师
  "medic": "string",             <-- 实习医师
  "coder": "string",             <-- 病案编码员
  "qc": "string",                <-- 病案质量
  "qcDoctor": "string",          <-- 质控医师
  "qcNurse": "string",           <-- 质控护士
  "qcDate": "string",            <-- 质控日期
  "outway": "string",            <-- 离院方式
  "recHos": "string",            <-- 拟接收医疗机构
  "disSituation": "string",      <-- 出院情况
  "rescueTimes": 0,              <-- 抢救次数
  "succResTimes": 0,             <-- 抢救成功次数
  "isClinPathway": false,        <-- 是否实施临床路径
  "isCmTechUsed": false,         <-- 是否使用中医技术
  "isDialNursUsed": false,       <-- 是否辨证施护
  "isReadmission": false,        <-- 是否出院31天内再住院
  "readmPurpose": "string",      <-- 出院31天内再住院目的
  "ptaComaDuration": "string",   <-- 颅脑损伤患者入院前昏迷时间
  "paComaDuration": "string",    <-- 颅脑损伤患者入院后昏迷时间
  "diagAccRateOpAndIp": "string",       <-- 诊断符合情况-门诊与住院
  "diagAccRateAdmAndDis": "string",     <-- 诊断符合情况-入院与出院
  "diagAccRatePreOpAndPostOp": "string",<-- 诊断符合情况-术前与术后
  "diagAccRateCliAndPat": "string",     <-- 诊断符合情况-临床与病理
  "diagAccRateRadAndPat": "string",     <-- 诊断符合情况-放射与病理
  "cmDiagnosis": "string",       <-- 门（急）诊诊断（中医诊断）
  "cmSymptom": "string",         <-- 门（急）诊诊断（中医证候）
  "isMedInsCmDrugUsed": false,   <-- 是否使用医疗机构中药制剂
  "isCmDiagEquipUsed": false,    <-- 是否使用中医诊疗设备
  "birthplaceProvince": "string",         <-- 出生地_省
  "birthplaceCity": "string",         <-- 出生地_市(地区、州)
  "birthplaceCounty": "string",         <-- 户口地址-县（区）
  "nativeplaceProvince": "string",         <-- 籍贯_省(区、市
  "nativeplaceCity": "string",         <-- 籍贯_市
  "contactsPhone": "string",         <-- 联系人电话
}
```


#### 2.10. 获取个人的住院病案首页的费用信息

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次住院的病案首页的费用信息。

**URL** : `/api/v1/health/person/med/homepage-fee`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
  "bldFee": 0,       <-- 血液和血液制品类_血费
  "bldAlbFee": 0,    <-- 血液和血液制品类_白蛋白类制品费
  "bldBcfFee": 0,    <-- 血液和血液制品类_凝血因子类制品费
  "bldCytFee": 0,    <-- 血液和血液制品类_细胞因子类制品费
  "bldGlbFee": 0,    <-- 血液和血液制品类_球蛋白类制品费
  "cmFee": 0,        <-- 中医类_中医治疗费
  "cmChmFee": 0,     <-- 中药类_中草药费
  "cmCpmFee": 0,     <-- 中药类_中成药费
  "cseCurFee": 0,    <-- 耗材类_治疗用一次性医用材料费
  "cseExmFee": 0,    <-- 耗材类_检查用一次性医用材料费
  "cseOpeFee": 0,    <-- 耗材类_手术用一次性医用材料费
  "curNopFee": 0,    <-- 治疗_非手术治疗项目费
  "curNopPhyFee": 0, <-- 治疗_非手术治疗项目费_临床物理治疗费
  "curOpeFee": 0,    <-- 治疗_手术治疗费
  "curOpeAnaFee": 0, <-- 治疗_手术治疗费_麻醉费
  "curOpeOpeFee": 0, <-- 治疗_手术治疗费_手术费
  "diagCliFee": 0,   <-- 诊断_临床诊断项目费
  "diagImgFee": 0,   <-- 诊断_影像学诊断费
  "diagLabFee": 0,   <-- 诊断_实验室诊断费
  "diagPatFee": 0,   <-- 诊断_病理诊断费
  "otsFee": 0,       <-- 其他类_其他费
  "rehFee": 0,       <-- 康复类_康复费
  "smsCurFee": 0,    <-- 综合医疗服务费_一般治疗操作费
  "smsNurFee": 0,    <-- 综合医疗服务费_护理费
  "smsOtrFee": 0,    <-- 综合医疗服务费_其他费用
  "smsSrvFee": 0,    <-- 综合医疗服务费_一般医疗服务费
  "ttlFee": 0,       <-- 住院总费用
  "ttlZfuFee": 0,    <-- 住院总费用_自付金额
  "wmMedFee": 0,     <-- 西药类_西药费
  "wmMedAntFee": 0,  <-- 西药类_西药费_抗菌药物费用
}
```

#### 2.11. 获取个人的住院出院小结

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次住院的出院小结信息。

**URL** : `/api/v1/health/person/med/summary`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
  "admSituation": "string",      <-- 入院情况
  "admDiagnosis": "string",      <-- 入院诊断
  "treatProcess": "string",      <-- 诊疗经过及结果
  "disSituation": "string",      <-- 出院情况
  "disDiagnosis": "string",      <-- 出院诊断
  "disAdvice": "string",         <-- 出院医嘱
  "recorder": "string",          <-- 记录医师
}
```

#### 2.12. 获取个人的住院电子病历首页诊断信息

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次住院的电子病历首页诊断信息。

**URL** : `/api/v1/health/person/med/homepage-diagnoses`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "code": "string",            <-- 疾病诊断编码
    "name": "string",            <-- 疾病诊断名称
    "parimary": false,           <-- 是否主诊断
    "order": "string",           <-- 诊断顺位
  },
  ...                            <-- 其他病案首页诊断信息
]
```

#### 2.13. 获取个人的住院电子病历首页手术信息

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次住院的电子病历首页手术信息。

**URL** : `/api/v1/health/person/med/homepage-operations`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "code": "string",            <-- 手术及操作编码
    "name": "string",            <-- 手术操作名称
    "operDt": "datetime",        <-- 手术操作日期时间
    "level": "string",           <-- 手术级别
    "incision": "string",        <-- 手术切口类别
    "intention": "string",       <-- 切口愈合等级
    "surgeon": "string",         <-- 手术医生
    "anesthetist": "string",     <-- 麻醉师
    "assistant1": "string",      <--ⅰ助姓名
    "assistant2": "string",      <--ⅱ助姓名
  },
  ...                            <-- 其他病案首页手术操作信息
]
```
#### 2.14. 获取住院病案首页

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次住院的病案首页。

**URL** : `/api/v1/health/person/med/homepage`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
  "base":{
        "medOrgName": "string",        <-- 医疗机构名称
        "orgLicNo": "string",          <-- 组织机构代码
        "paymentWay": "string",        <-- 医疗费用支付方式
        "inHosTimes": "string",        <-- 住院次数
        "healthCardNo": "string",      <-- 居民健康卡号
        "insurCardNo": "string",       <-- 医保卡号
        "visitNo": "string",           <-- 就诊流水号
        "medRecordNo": "string",       <-- 病案号
        "name": "string",              <-- 姓名
        "gender": "string",            <-- 性别
        "age": 0,                      <-- 年龄
        "birthday": "date",            <-- 出生日期
        "country": "string",           <-- 国籍
        "nativeplace": "string",       <-- 籍贯
        "nation": "string",            <-- 民族
        "ageMonths": 0,                <-- 月龄
        "birthWeight": 0,              <-- 新生儿出生体重(g)
        "admWeight": 0,                <-- 新生儿入院体重(g)
        "idType": "string",            <-- 证件类型
        "idCardNo": "string",          <-- 证件号码
        "occupation": "string",        <-- 职业类别
        "marStatus": "string",         <-- 婚姻状况
        "address": "string",           <-- 现住址
        "telephone": "string",         <-- 联系电话
        "registry": "string",          <-- 户口
        "unitName": "string",          <-- 工作单位名称
        "unitAddr": "string",          <-- 工作单位地址
        "unitPhone": "string",         <-- 工作单位电话号码
        "contName": "string",          <-- 联系人姓名
        "contAddr": "string",          <-- 联系人地址
        "contPhone": "string",         <-- 联系人电话号码
        "relationship": "string",      <-- 联系人与患者的关系
        "admWays": "string",           <-- 入院途径
        "admDate": "string",           <-- 入院日期
        "admDept": "string",           <-- 入院科室
        "admWard": "string",           <-- 入院病房
        "refDept": "string",           <-- 转科科室
        "disDate": "string",           <-- 出院日期
        "disDept": "string",           <-- 出院科室
        "disWard": "string",           <-- 出院病房
        "inHosDays": "string",         <-- 住院天数
        "clinDiagCode": "string",      <-- 门(急)诊诊断名称
        "clinDiagName": "string",      <-- 门(急)诊诊断编码
        "poisonReason": "string",      <-- 损伤中毒的外部原因
        "pathDiagCode": "string",      <-- 病理诊断编码
        "pathDiagName": "string",      <-- 病理诊断名称
        "pathologyNo": "string",       <-- 病理号
        "isAllergy": false,            <-- 是否药物过敏
        "allergyDrug": "string",       <-- 过敏药物
        "isAutopsy": false,            <-- 是否死亡患者尸检
        "aboBlood": "string",          <-- ABO血型
        "rhBlood": "string",           <-- Rh血型
        "director": "string",          <-- 科主任
        "chiefPhy": "string",          <-- 主任(副主任)医师
        "phyInCha": "string",          <-- 主治医师
        "resident": "string",          <-- 住院医师
        "prNurse": "string",           <-- 责任护士
        "trainee": "string",           <-- 进修医师
        "medic": "string",             <-- 实习医师
        "coder": "string",             <-- 病案编码员
        "qc": "string",                <-- 病案质量
        "qcDoctor": "string",          <-- 质控医师
        "qcNurse": "string",           <-- 质控护士
        "qcDate": "string",            <-- 质控日期
        "outway": "string",            <-- 离院方式
        "recHos": "string",            <-- 拟接收医疗机构
        "disSituation": "string",      <-- 出院情况
        "rescueTimes": 0,              <-- 抢救次数
        "succResTimes": 0,             <-- 抢救成功次数
        "isClinPathway": false,        <-- 是否实施临床路径
        "isCmTechUsed": false,         <-- 是否使用中医技术
        "isDialNursUsed": false,       <-- 是否辨证施护
        "isReadmission": false,        <-- 是否出院31天内再住院
        "readmPurpose": "string",      <-- 出院31天内再住院目的
        "ptaComaDuration": "string",   <-- 颅脑损伤患者入院前昏迷时间
        "paComaDuration": "string",    <-- 颅脑损伤患者入院后昏迷时间
        "diagAccRateOpAndIp": "string",       <-- 诊断符合情况-门诊与住院
        "diagAccRateAdmAndDis": "string",     <-- 诊断符合情况-入院与出院
        "diagAccRatePreOpAndPostOp": "string",<-- 诊断符合情况-术前与术后
        "diagAccRateCliAndPat": "string",     <-- 诊断符合情况-临床与病理
        "diagAccRateRadAndPat": "string",     <-- 诊断符合情况-放射与病理
        "cmDiagnosis": "string",       <-- 门（急）诊诊断（中医诊断）
        "cmSymptom": "string",         <-- 门（急）诊诊断（中医证候）
        "isMedInsCmDrugUsed": false,   <-- 是否使用医疗机构中药制剂
        "isCmDiagEquipUsed": false,    <-- 是否使用中医诊疗设备
        "birthplaceProvince": "string",         <-- 出生地_省
        "birthplaceCity": "string",         <-- 出生地_市(地区、州)
        "birthplaceCounty": "string",         <-- 户口地址-县（区）
        "nativeplaceProvince": "string",         <-- 籍贯_省(区、市
        "nativeplaceCity": "string",         <-- 籍贯_市
        "contactsPhone": "string",         <-- 联系人电话
        "admDeptCode": "string",         <-- 入院科室编码
        "disDeptCode": "string",         <-- 出院科室编码
  },
  "fee":{
        "bldFee": 0,       <-- 血液和血液制品类_血费
        "bldAlbFee": 0,    <-- 血液和血液制品类_白蛋白类制品费
        "bldBcfFee": 0,    <-- 血液和血液制品类_凝血因子类制品费
        "bldCytFee": 0,    <-- 血液和血液制品类_细胞因子类制品费
        "bldGlbFee": 0,    <-- 血液和血液制品类_球蛋白类制品费
        "cmFee": 0,        <-- 中医类_中医治疗费
        "cmChmFee": 0,     <-- 中药类_中草药费
        "cmCpmFee": 0,     <-- 中药类_中成药费
        "cseCurFee": 0,    <-- 耗材类_治疗用一次性医用材料费
        "cseExmFee": 0,    <-- 耗材类_检查用一次性医用材料费
        "cseOpeFee": 0,    <-- 耗材类_手术用一次性医用材料费
        "curNopFee": 0,    <-- 治疗_非手术治疗项目费
        "curNopPhyFee": 0, <-- 治疗_非手术治疗项目费_临床物理治疗费
        "curOpeFee": 0,    <-- 治疗_手术治疗费
        "curOpeAnaFee": 0, <-- 治疗_手术治疗费_麻醉费
        "curOpeOpeFee": 0, <-- 治疗_手术治疗费_手术费
        "diagCliFee": 0,   <-- 诊断_临床诊断项目费
        "diagImgFee": 0,   <-- 诊断_影像学诊断费
        "diagLabFee": 0,   <-- 诊断_实验室诊断费
        "diagPatFee": 0,   <-- 诊断_病理诊断费
        "otsFee": 0,       <-- 其他类_其他费
        "rehFee": 0,       <-- 康复类_康复费
        "smsCurFee": 0,    <-- 综合医疗服务费_一般治疗操作费
        "smsNurFee": 0,    <-- 综合医疗服务费_护理费
        "smsOtrFee": 0,    <-- 综合医疗服务费_其他费用
        "smsSrvFee": 0,    <-- 综合医疗服务费_一般医疗服务费
        "ttlFee": 0,       <-- 住院总费用
        "ttlZfuFee": 0,    <-- 住院总费用_自付金额
        "wmMedFee": 0,     <-- 西药类_西药费
        "wmMedAntFee": 0,  <-- 西药类_西药费_抗菌药物费用
  },
  
    "diagnoses" : [
      {
        "admSituation": "string",      <-- 入院情况
        "admDiagnosis": "string",      <-- 入院诊断
        "treatProcess": "string",      <-- 诊疗经过及结果
        "disSituation": "string",      <-- 出院情况
        "disDiagnosis": "string",      <-- 出院诊断
        "disAdvice": "string",         <-- 出院医嘱
        "recorder": "string",          <-- 记录医师
      },
    ...                <-- 其他病案首页诊断信息
    ],
    "operations" : [
      {
        "code": "string",            <-- 手术及操作编码
        "name": "string",            <-- 手术操作名称
        "operDt": "datetime",        <-- 手术操作日期时间
        "level": "string",           <-- 手术级别
        "incision": "string",        <-- 手术切口类别
        "intention": "string",       <-- 切口愈合等级
        "surgeon": "string",         <-- 手术医生
        "anesthetist": "string",     <-- 麻醉师
        "assistant1": "string",      <--ⅰ助姓名
        "assistant2": "string",      <--ⅱ助姓名
      },
    ...                <-- 其他病案首页手术信息
    ]
}

```
#### 2.15. 获取个人的住院明细一览

通过证件类型、证件号码和姓名，获取此人的住院明细一览，其中姓名是可选项。

**URL** : `/api/v1/health/person/inpatient-records`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |


**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
      "visitNo": "string",      <-- 就诊流水号
      "type": 0,                <-- 门诊/住院，1：门诊，2：住院
      "medicalKind": "string",  <-- 医疗类别
      "medicalKindCode": "string",  <-- 医疗类别编码
      "admDate": "date",        <-- 门诊的就诊日期，住院的入院日期
      "disDate": "date",        <-- 出院日期
      "medOrgName": "string",   <-- 医疗机构
      "medOrgCode":"String"		<-- 医疗机构编码
      "medOrgLvl": "string",    <-- 医疗机构等级
      "department": "string",   <-- 科室
      "doctor": "string",       <-- 医生
      "inHosDays": "string",    <-- 住院天数
      "drgsCode": "string",     <-- DRGs分组编码
      "drgsName": "string",     <-- DRGs分组名称
      "diagnoses": [            <-- 就诊诊断
      {
        "icdCode": "string",  <-- ICD诊断编码
        "icdName": "string",  <-- ICD诊断名称
        "isPrincipal": false, <-- 是否主诊断，true：主诊断，false：非主诊断
        "typeCode": "string",     <-- 诊断类别编码
        "typeName": "string",     <-- 诊断类别名称
        "order": 0,           <-- 诊断顺位
      },
      ...                     <-- 其他诊断结果
      ],
      "homepage":{
                   "medOrgName": "string",        <-- 医疗机构名称
                   "orgLicNo": "string",          <-- 组织机构代码
                   "paymentWay": "string",        <-- 医疗费用支付方式
                   "inHosTimes": "string",        <-- 住院次数
                   "healthCardNo": "string",      <-- 居民健康卡号
                   "insurCardNo": "string",       <-- 医保卡号
                   "visitNo": "string",           <-- 就诊流水号
                   "medRecordNo": "string",       <-- 病案号
                   "name": "string",              <-- 姓名
                   "gender": "string",            <-- 性别
                   "age": 0,                      <-- 年龄
                   "birthday": "date",            <-- 出生日期
                   "country": "string",           <-- 国籍
                   "nativeplace": "string",       <-- 籍贯
                   "nation": "string",            <-- 民族
                   "ageMonths": 0,                <-- 月龄
                   "birthWeight": 0,              <-- 新生儿出生体重(g)
                   "admWeight": 0,                <-- 新生儿入院体重(g)
                   "idType": "string",            <-- 证件类型
                   "idCardNo": "string",          <-- 证件号码
                   "occupation": "string",        <-- 职业类别
                   "marStatus": "string",         <-- 婚姻状况
                   "address": "string",           <-- 现住址
                   "telephone": "string",         <-- 联系电话
                   "registry": "string",          <-- 户口
                   "unitName": "string",          <-- 工作单位名称
                   "unitAddr": "string",          <-- 工作单位地址
                   "unitPhone": "string",         <-- 工作单位电话号码
                   "contName": "string",          <-- 联系人姓名
                   "contAddr": "string",          <-- 联系人地址
                   "contPhone": "string",         <-- 联系人电话号码
                   "relationship": "string",      <-- 联系人与患者的关系
                   "admWays": "string",           <-- 入院途径
                   "admDate": "string",           <-- 入院日期
                   "admDept": "string",           <-- 入院科室
                   "admWard": "string",           <-- 入院病房
                   "refDept": "string",           <-- 转科科室
                   "disDate": "string",           <-- 出院日期
                   "disDept": "string",           <-- 出院科室
                   "disWard": "string",           <-- 出院病房
                   "inHosDays": "string",         <-- 住院天数
                   "clinDiagCode": "string",      <-- 门(急)诊诊断名称
                   "clinDiagName": "string",      <-- 门(急)诊诊断编码
                   "poisonReason": "string",      <-- 损伤中毒的外部原因
                   "pathDiagCode": "string",      <-- 病理诊断编码
                   "pathDiagName": "string",      <-- 病理诊断名称
                   "pathologyNo": "string",       <-- 病理号
                   "isAllergy": false,            <-- 是否药物过敏
                   "allergyDrug": "string",       <-- 过敏药物
                   "isAutopsy": false,            <-- 是否死亡患者尸检
                   "aboBlood": "string",          <-- ABO血型
                   "rhBlood": "string",           <-- Rh血型
                   "director": "string",          <-- 科主任
                   "chiefPhy": "string",          <-- 主任(副主任)医师
                   "phyInCha": "string",          <-- 主治医师
                   "resident": "string",          <-- 住院医师
                   "prNurse": "string",           <-- 责任护士
                   "trainee": "string",           <-- 进修医师
                   "medic": "string",             <-- 实习医师
                   "coder": "string",             <-- 病案编码员
                   "qc": "string",                <-- 病案质量
                   "qcDoctor": "string",          <-- 质控医师
                   "qcNurse": "string",           <-- 质控护士
                   "qcDate": "string",            <-- 质控日期
                   "outway": "string",            <-- 离院方式
                   "recHos": "string",            <-- 拟接收医疗机构
                   "disSituation": "string",      <-- 出院情况
                   "rescueTimes": 0,              <-- 抢救次数
                   "succResTimes": 0,             <-- 抢救成功次数
                   "isClinPathway": false,        <-- 是否实施临床路径
                   "isCmTechUsed": false,         <-- 是否使用中医技术
                   "isDialNursUsed": false,       <-- 是否辨证施护
                   "isReadmission": false,        <-- 是否出院31天内再住院
                   "readmPurpose": "string",      <-- 出院31天内再住院目的
                   "ptaComaDuration": "string",   <-- 颅脑损伤患者入院前昏迷时间
                   "paComaDuration": "string",    <-- 颅脑损伤患者入院后昏迷时间
                   "diagAccRateOpAndIp": "string",       <-- 诊断符合情况-门诊与住院
                   "diagAccRateAdmAndDis": "string",     <-- 诊断符合情况-入院与出院
                   "diagAccRatePreOpAndPostOp": "string",<-- 诊断符合情况-术前与术后
                   "diagAccRateCliAndPat": "string",     <-- 诊断符合情况-临床与病理
                   "diagAccRateRadAndPat": "string",     <-- 诊断符合情况-放射与病理
                   "cmDiagnosis": "string",       <-- 门（急）诊诊断（中医诊断）
                   "cmSymptom": "string",         <-- 门（急）诊诊断（中医证候）
                   "isMedInsCmDrugUsed": false,   <-- 是否使用医疗机构中药制剂
                   "isCmDiagEquipUsed": false,    <-- 是否使用中医诊疗设备
                   "birthplaceProvince": "string",         <-- 出生地_省
                   "birthplaceCity": "string",         <-- 出生地_市(地区、州)
                   "birthplaceCounty": "string",         <-- 户口地址-县（区）
                   "nativeplaceProvince": "string",         <-- 籍贯_省(区、市
                   "nativeplaceCity": "string",         <-- 籍贯_市
                   "contactsPhone": "string",         <-- 联系人电话
      },
      "summary" : {
                  "admSituation": "string",      <-- 入院情况
                  "admDiagnosis": "string",      <-- 入院诊断
                  "treatProcess": "string",      <-- 诊疗经过及结果
                  "disSituation": "string",      <-- 出院情况
                  "disDiagnosis": "string",      <-- 出院诊断
                  "disAdvice": "string",         <-- 出院医嘱
                  "recorder": "string",          <-- 记录医师
      },
      "emrDiags":[
                    {
                      "code": "string",            <-- 疾病诊断编码
                      "name": "string",            <-- 疾病诊断名称
                      "parimary": false,           <-- 是否主诊断
                      "order": "string",           <-- 诊断顺位
                    },
                    ...                            <-- 其他病案首页诊断信息
      ],
      "emrOpers":[
                   {
                     "code": "string",            <-- 手术及操作编码
                     "name": "string",            <-- 手术操作名称
                     "operDt": "datetime",        <-- 手术操作日期时间
                     "level": "string",           <-- 手术级别
                     "incision": "string",        <-- 手术切口类别
                     "intention": "string",       <-- 切口愈合等级
                     "surgeon": "string",         <-- 手术医生
                     "anesthetist": "string",     <-- 麻醉师
                     "assistant1": "string",      <--ⅰ助姓名
                     "assistant2": "string",      <--ⅱ助姓名
                   },
                   ...                            <-- 其他病案首页手术操作信息
      ],
      "bills" : [
        {
          "billNo" : "string",                     <-- 单据号
          "items" :[
                     {
                       "billNo": "string",         <-- 单据号
                       "presNo": "string",         <-- 处方号
                       "presDt": "datetime",       <-- 处方日期时间
                       "accountingDt": "datetime", <-- 医院结算日期
                       "categoryCode": "string",   <-- 项目类别代码
                       "categoryName": "string",   <-- 项目类别名称
                       "code": "string",           <-- 收费项目代码
                       "name": "string",           <-- 收费项目名称
                       "spec": "string",           <-- 规格     
                       "amount": 0,                <-- 数量
                       "unit": "string",           <-- 单位
                       "price": "string",          <-- 单价
                       "chargeLevel": "string",    <-- 收费项目等级
                       "fee": 0,                   <-- 金额
                       "manufacture": "string",    <-- 生产企业名称
                       "maxPrice": "string",       <-- 限价
                       "condition": "string",      <-- 限药
                       "zliFee": 0                 <-- 自理金额
                       "zfeFee": 0,                <-- 自费金额
                       "elpZfuFee": 0,             <-- 超限价自付金额
                       "zfuPer": 0,                <-- 自付比例
                       "socPooZliFee": 0,          <-- 统筹自理
                       "consZliFee": 0,            <-- 大额自理
                       "consZfuPer": 0,            <-- 大额自付比例
                       "exConApLClsBZliFee": 0,    <-- 超大额封顶以上乙类自理
                       "exConApLZfuPer": 0,        <-- 超大额封顶线以上自付比例
                     },
                     ...                           <-- 其他费用明细记录
                   ]
        },
        ...                           <-- 其他账单记录
      ],
      "reports" : [
          {
            "specNo": "string",          <-- 检验标本号
            "personName": "string",      <-- 患者姓名
            "gender": "string",          <-- 性别
            "age": "int",                <-- 年龄
            "specDt": "datetime",        <-- 接收标本的日期时间
            "specKind": "string",        <-- 标本类别
            "specStatus": "string",      <-- 标本状态
            "clinDiag": "string",        <-- 临床诊断
            "projects": [                <-- 检验
              {
                "testName": "string",    <-- 检验方法
                "testDt": "datetime",    <-- 检验日期
                "physician": "string",   <-- 检验医生
                "testNo": "string",      <-- 检验报告单编号
                "memo": "string",        <-- 检验报告备注
                "items": [               <-- 检验项目
                  {
                    "no": "string",      <-- 检验项目序号
                    "code": "string",    <-- 检验项目代码
                    "name": "string",    <-- 检验项目名称
                    "result": "string",  <-- 检验结果
                    "refVal": "string",  <-- 参考值
                    "unit": "string",    <-- 单位
                    "sign": "string",    <-- 指标异常
                  },
                  ...                    <-- 其他检验项目
                ],
              },
              ...                        <-- 其他检验
            ],
          },
          ...                            <-- 其他检验报告
      ],
      "exams":[
        {
          "appFormNo": "string",       <-- 电子申请单编号
          "specDt": "datetime",        <-- 送检日期
          "specKind": "string",        <-- 标本类别
          "specStatus": "string",      <-- 标本状态
          "specNo": "string",          <-- 检查标本号
          "examPart": "string",        <-- 检查部位
          "type": "string",            <-- 检查类型
          "complaint": "string",       <-- 主诉
          "symptom": "string",         <-- 症状描述
          "specFixative": "string",    <-- 标本固定液
          "process": "string",         <-- 诊疗过程描述
          "reportNo": "string",        <-- 检查报告单编号
          "objReport": "string",       <-- 检查报告结果-客观所见
          "subReport": "string",       <-- 检查报告结果-主观提示
          "memo": "string",            <-- 检查报告备注
          "reportDt": "datetime",      <-- 检查报告日期时间
          "itemName": "string",        <-- 检查项目名称
          "itemResult": "string",      <-- 检查项目结果
          "ultraImgReport": "string",  <-- 影像与超声检查
          "examinationPerson": "string",        <-- 审核医师
          "reportPerson": "string",      <-- 报告医师
          "clinicalDiagnosis": "string",  <-- 临床诊断
        },
        ...                            <-- 其他检查记录
      ],
      "advices" : [
        {
          "adviceDt": "datetime",      <-- 下达医嘱的日期时间
          "items": [                   <-- 医嘱项目
            {
              "adviceNo": "string",    <-- 医嘱流水号      
              "code": "string",        <-- 医嘱项目编码
              "name": "string",        <-- 医嘱项目名称
              "type": "string",        <-- 医嘱项目类别
              "dose": "string",        <-- 每次用量
              "unit": "string",        <-- 剂量单位
              "total": "string",       <-- 总量
              "daily": "string",       <-- 日频次
              "freq": "string",        <-- 使用频次
              "usage": "string",       <-- 用法
              "miniDose": "string",    <-- 最小剂量
              "miniDoseUnit": "string",<-- 最小剂量单位
              "groupId": "string",     <-- 组合号
              "startDt": "datetime",   <-- 医嘱开始执行的日期时间
              "startDoctor": "string", <-- 开始医生
              "startNurse": "string",  <-- 开始护士
              "stopDt": "datetime",    <-- 医嘱停止的日期时间
              "stopDoctor": "string",  <-- 停止医生        
              "stopExecDt": "datetime",<-- 停止执行时间
              "stopNurse": "string",   <-- 停止护士
              "isLongAdvice": false,   <-- 是否长期医嘱，true：长期医嘱，false：一般医嘱
              "isValuation": false,    <-- 是否计价，true：计价，false：不计价
              "isInvalid": false,      <-- 医嘱是否作废，true：作废，false：正常        
            },
            ...                        <-- 其他医嘱项目
          ],
        },
        ...                            <-- 其他医嘱
      ],
      "operations" : [
           {
             "no": "string",              <-- 手术编号
             "name": "string",            <-- 手术名称
             "opeDt": "datetime",         <-- 手术日期时间
             "opeLvl": "string",          <-- 手术级别
             "opePos": "string",          <-- 手术体位
             "opeHis": "string",          <-- 手术史标志
             "aob": "string",             <-- 出血量
             "aot": "string",             <-- 输血量
             "plcPos": "string",          <-- 放置部位
             "incision": "string",        <-- 手术切口描述
             "premedicate": "string",     <-- 术前用药
             "damName": "string",         <-- 引流材料名称
             "damAmount": "string",       <-- 引流材料数目
             "before": "string",          <-- 术前诊断
             "after": "string",           <-- 术后诊断
             "process": "string",         <-- 过程描述
             "anesthesia": "string",      <-- 麻醉方式
             "surgeon": "string",         <-- 手术医生
             "analgesist": "string",      <-- 麻醉师
             "assistants": "string",      <-- 手术助手
             "startTime":"string",		 <-- 手术开始时间
             "endTime":"string"		     <-- 手术结束时间
           },
           ...                            <-- 其他手术记录
     ],
     "drugs" : [
         {
           "billNo": "string",          <-- 单据号
           "presNo": "string",          <-- 处方号
           "presDt": "datetime",        <-- 处方日期时间
           "categoryCode": "string",    <-- 项目类别代码
           "categoryName": "string",    <-- 项目类别名称
           "hItemCode": "string",       <-- 医院收费项目代码
           "mItemCode": "string",       <-- 付费方收费项目代码
           "name": "string",            <-- 收费项目名称
           "spec": "string",            <-- 规格     
           "amount": "double",          <-- 数量
           "unit": "string",            <-- 单位
           "price": "string",           <-- 单价
           "chargeLevel": "string",     <-- 收费项目等级
           "fee": 0,                    <-- 金额
           "manufacture": "string",     <-- 生产企业名称
           "drugApprovalNo": "string",  <-- 药品批准文号
           "otc": "string",             <-- OTC标识
           "executionTime": "string",   <-- 执行日期
         },
         ...                            <-- 其他使用药品
      ],
      "items" : [
          {
            "billNo": "string",          <-- 单据号
            "presNo": "string",          <-- 处方号
            "presDt": "datetime",        <-- 处方日期时间
            "categoryCode": "string",    <-- 项目类别代码
            "categoryName": "string",    <-- 项目类别名称
            "hItemCode": "string",       <-- 医院收费项目代码
            "mItemCode": "string",       <-- 付费方收费项目代码
            "name": "string",            <-- 收费项目名称
            "spec": "string",            <-- 规格     
            "amount": 0,                 <-- 数量
            "unit": "string",            <-- 单位
            "price": "string",           <-- 单价
            "chargeLevel": "string",     <-- 收费项目等级
            "fee": 0,                    <-- 金额
            "manufacture": "string",     <-- 生产企业名称
            "ceilingPrice": "string",	 <-- 最高限价
          },
          ...                            <-- 其他诊疗项目
      ],
      "payInfos": [
          {
            "biPayment": "BigDecimal",  <-- 商保支付
            "billNo": "string",   <-- 单据号
            "cashPayment": "BigDecimal",  <-- 现金支付
            "catastrophicDiseasePayment": "BigDecimal",   <-- 大病支付
            "civilReliefFundPayment": "BigDecimal",   <-- 民政救助保险支付
            "clinicCost": "BigDecimal",  <-- 诊疗项目费用
            "csSubsidyPayment": "BigDecimal", <-- 公务员医疗保险支付
            "drugCost": "BigDecimal", <-- 药品费用
            "entSupFundPayment": "BigDecimal",    <-- 企业补充基金支付
            "facilitiesCost": "BigDecimal", <-- 服务设施费用
            "insuranceKind": "string",    <-- 险种类型
            "materialCost": "BigDecimal", <-- 单独支付材料总费用
            "materialCostFee": "BigDecimal",    <-- 单独支付材料总费用
            "miPrivateAccountPayment": "BigDecimal",    <-- 医保个人账户支付
            "miSocialPoolingPayment": "BigDecimal",   <-- 医保统筹支付
            "ownExpenseFee": "BigDecimal",  <-- 自费金额（丙类费用）
            "payDt": "string",      <-- 赔付时间
            "payee": "string",          <-- 赔付对象
            "payeeCode": "string",          <-- 赔付对象编码
            "personType": "string",           <-- 医疗人员类别
            "seriousIllness": "BigDecimal",       <-- 进入大病费用(住院)
            "subsistenceSecurityPayment": "BigDecimal",   <-- 低保补助
            "totalPayment": "BigDecimal",         <-- 医疗总费用
            "twoAllowance": "BigDecimal",         <-- 二次补助(自付封顶补助)
            "visitNo": "string"                   <-- 就诊流水号
            "perSupFundPayment": 0,                  <-- 个人基金账户支付
          },
        ...                            <-- 其他医保付费信息
        ]
  },
  ...                            <-- 其他住院明细信息
]
```
#### 2.16. 获取个人的门诊就诊明细一览

通过证件类型、证件号码和姓名，获取此人的门诊就诊明细一览，其中姓名是可选项。

**URL** : `/api/v1/health/person/outpatient-records`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |


**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
      "visitNo": "string",      <-- 就诊流水号
      "type": 0,                <-- 门诊/住院，1：门诊，2：住院
      "medicalKind": "string",  <-- 医疗类别
      "medicalKindCode": "string",  <-- 医疗类别编码
      "admDate": "date",        <-- 门诊的就诊日期，住院的入院日期
      "disDate": "date",        <-- 出院日期
      "medOrgName": "string",   <-- 医疗机构
      "medOrgCode":"String"		<-- 医疗机构编码
      "medOrgLvl": "string",    <-- 医疗机构等级
      "department": "string",   <-- 科室
      "doctor": "string",       <-- 医生
      "inHosDays": "string",    <-- 住院天数
      "drgsCode": "string",     <-- DRGs分组编码
      "drgsName": "string",     <-- DRGs分组名称
      "diagnoses": [            <-- 就诊诊断
      {
        "icdCode": "string",  <-- ICD诊断编码
        "icdName": "string",  <-- ICD诊断名称
        "isPrincipal": false, <-- 是否主诊断，true：主诊断，false：非主诊断
        "typeCode": "string",     <-- 诊断类别编码
        "typeName": "string",     <-- 诊断类别名称
        "order": 0,           <-- 诊断顺位
      },
      ...                     <-- 其他诊断结果
      ],
      "bills" : [
        {
          "billNo" : "string", <-- 单据号
          "items" :[
                     {
                       "billNo": "string",         <-- 单据号
                       "presNo": "string",         <-- 处方号
                       "presDt": "datetime",       <-- 处方日期时间
                       "accountingDt": "datetime", <-- 医院结算日期
                       "categoryCode": "string",   <-- 项目类别代码
                       "categoryName": "string",   <-- 项目类别名称
                       "code": "string",           <-- 收费项目代码
                       "name": "string",           <-- 收费项目名称
                       "spec": "string",           <-- 规格     
                       "amount": 0,                <-- 数量
                       "unit": "string",           <-- 单位
                       "price": "string",          <-- 单价
                       "chargeLevel": "string",    <-- 收费项目等级
                       "fee": 0,                   <-- 金额
                       "manufacture": "string",    <-- 生产企业名称
                       "maxPrice": "string",       <-- 限价
                       "condition": "string",      <-- 限药
                       "zliFee": 0                 <-- 自理金额
                       "zfeFee": 0,                <-- 自费金额
                       "elpZfuFee": 0,             <-- 超限价自付金额
                       "zfuPer": 0,                <-- 自付比例
                       "socPooZliFee": 0,          <-- 统筹自理
                       "consZliFee": 0,            <-- 大额自理
                       "consZfuPer": 0,            <-- 大额自付比例
                       "exConApLClsBZliFee": 0,    <-- 超大额封顶以上乙类自理
                       "exConApLZfuPer": 0,        <-- 超大额封顶线以上自付比例
                     },
                     ...                           <-- 其他费用明细记录
                   ]
        },
        ...                           <-- 其他账单记录
      ],
      "reports" : [
          {
            "specNo": "string",          <-- 检验标本号
            "personName": "string",      <-- 患者姓名
            "gender": "string",          <-- 性别
            "age": "int",                <-- 年龄
            "specDt": "datetime",        <-- 接收标本的日期时间
            "specKind": "string",        <-- 标本类别
            "specStatus": "string",      <-- 标本状态
            "clinDiag": "string",        <-- 临床诊断
            "projects": [                <-- 检验
              {
                "testName": "string",    <-- 检验方法
                "testDt": "datetime",    <-- 检验日期
                "physician": "string",   <-- 检验医生
                "testNo": "string",      <-- 检验报告单编号
                "memo": "string",        <-- 检验报告备注
                "items": [               <-- 检验项目
                  {
                    "no": "string",      <-- 检验项目序号
                    "code": "string",    <-- 检验项目代码
                    "name": "string",    <-- 检验项目名称
                    "result": "string",  <-- 检验结果
                    "refVal": "string",  <-- 参考值
                    "unit": "string",    <-- 单位
                    "sign": "string",    <-- 指标异常
                  },
                  ...                    <-- 其他检验项目
                ],
              },
              ...                        <-- 其他检验
            ],
          },
          ...                            <-- 其他检验报告
      ],
      "exams":[
        {
          "appFormNo": "string",       <-- 电子申请单编号
          "specDt": "datetime",        <-- 送检日期
          "specKind": "string",        <-- 标本类别
          "specStatus": "string",      <-- 标本状态
          "specNo": "string",          <-- 检查标本号
          "examPart": "string",        <-- 检查部位
          "type": "string",            <-- 检查类型
          "complaint": "string",       <-- 主诉
          "symptom": "string",         <-- 症状描述
          "specFixative": "string",    <-- 标本固定液
          "process": "string",         <-- 诊疗过程描述
          "reportNo": "string",        <-- 检查报告单编号
          "objReport": "string",       <-- 检查报告结果-客观所见
          "subReport": "string",       <-- 检查报告结果-主观提示
          "memo": "string",            <-- 检查报告备注
          "reportDt": "datetime",      <-- 检查报告日期时间
          "itemName": "string",        <-- 检查项目名称
          "itemResult": "string",      <-- 检查项目结果
          "ultraImgReport": "string",  <-- 影像与超声检查
          "examinationPerson": "string",        <-- 审核医师
          "reportPerson": "string",      <-- 报告医师
          "clinicalDiagnosis": "string",  <-- 临床诊断
        },
        ...                            <-- 其他检查记录
      ],
      "advices" : [
        {
          "adviceDt": "datetime",      <-- 下达医嘱的日期时间
          "items": [                   <-- 医嘱项目
            {
              "adviceNo": "string",    <-- 医嘱流水号      
              "code": "string",        <-- 医嘱项目编码
              "name": "string",        <-- 医嘱项目名称
              "type": "string",        <-- 医嘱项目类别
              "dose": "string",        <-- 每次用量
              "unit": "string",        <-- 剂量单位
              "total": "string",       <-- 总量
              "daily": "string",       <-- 日频次
              "freq": "string",        <-- 使用频次
              "usage": "string",       <-- 用法
              "miniDose": "string",    <-- 最小剂量
              "miniDoseUnit": "string",<-- 最小剂量单位
              "groupId": "string",     <-- 组合号
              "startDt": "datetime",   <-- 医嘱开始执行的日期时间
              "startDoctor": "string", <-- 开始医生
              "startNurse": "string",  <-- 开始护士
              "stopDt": "datetime",    <-- 医嘱停止的日期时间
              "stopDoctor": "string",  <-- 停止医生        
              "stopExecDt": "datetime",<-- 停止执行时间
              "stopNurse": "string",   <-- 停止护士
              "isLongAdvice": false,   <-- 是否长期医嘱，true：长期医嘱，false：一般医嘱
              "isValuation": false,    <-- 是否计价，true：计价，false：不计价
              "isInvalid": false,      <-- 医嘱是否作废，true：作废，false：正常        
            },
            ...                        <-- 其他医嘱项目
          ],
        },
        ...                            <-- 其他医嘱
      ],
      "operations" : [
           {
             "no": "string",              <-- 手术编号
             "name": "string",            <-- 手术名称
             "opeDt": "datetime",         <-- 手术日期时间
             "opeLvl": "string",          <-- 手术级别
             "opePos": "string",          <-- 手术体位
             "opeHis": "string",          <-- 手术史标志
             "aob": "string",             <-- 出血量
             "aot": "string",             <-- 输血量
             "plcPos": "string",          <-- 放置部位
             "incision": "string",        <-- 手术切口描述
             "premedicate": "string",     <-- 术前用药
             "damName": "string",         <-- 引流材料名称
             "damAmount": "string",       <-- 引流材料数目
             "before": "string",          <-- 术前诊断
             "after": "string",           <-- 术后诊断
             "process": "string",         <-- 过程描述
             "anesthesia": "string",      <-- 麻醉方式
             "surgeon": "string",         <-- 手术医生
             "analgesist": "string",      <-- 麻醉师
             "assistants": "string",      <-- 手术助手
             "startTime":"string",		 <-- 手术开始时间
             "endTime":"string"		     <-- 手术结束时间
           },
           ...                            <-- 其他手术记录
     ],
     "drugs" : [
         {
           "billNo": "string",          <-- 单据号
           "presNo": "string",          <-- 处方号
           "presDt": "datetime",        <-- 处方日期时间
           "categoryCode": "string",    <-- 项目类别代码
           "categoryName": "string",    <-- 项目类别名称
           "hItemCode": "string",       <-- 医院收费项目代码
           "mItemCode": "string",       <-- 付费方收费项目代码
           "name": "string",            <-- 收费项目名称
           "spec": "string",            <-- 规格     
           "amount": "double",          <-- 数量
           "unit": "string",            <-- 单位
           "price": "string",           <-- 单价
           "chargeLevel": "string",     <-- 收费项目等级
           "fee": 0,                    <-- 金额
           "manufacture": "string",     <-- 生产企业名称
           "drugApprovalNo": "string",  <-- 药品批准文号
           "otc": "string",             <-- OTC标识
           "executionTime": "string",   <-- 执行日期
         },
         ...                            <-- 其他使用药品
      ],
      "items" : [
          {
            "billNo": "string",          <-- 单据号
            "presNo": "string",          <-- 处方号
            "presDt": "datetime",        <-- 处方日期时间
            "categoryCode": "string",    <-- 项目类别代码
            "categoryName": "string",    <-- 项目类别名称
            "hItemCode": "string",       <-- 医院收费项目代码
            "mItemCode": "string",       <-- 付费方收费项目代码
            "name": "string",            <-- 收费项目名称
            "spec": "string",            <-- 规格     
            "amount": 0,                 <-- 数量
            "unit": "string",            <-- 单位
            "price": "string",           <-- 单价
            "chargeLevel": "string",     <-- 收费项目等级
            "fee": 0,                    <-- 金额
            "manufacture": "string",     <-- 生产企业名称
            "ceilingPrice": "string",	 <-- 最高限价
          },
          ...                            <-- 其他诊疗项目
      ],
     "payInfos": [
         {
           "biPayment": "BigDecimal",  <-- 商保支付
           "billNo": "string",   <-- 单据号
           "cashPayment": "BigDecimal",  <-- 现金支付
           "catastrophicDiseasePayment": "BigDecimal",   <-- 大病支付
           "civilReliefFundPayment": "BigDecimal",   <-- 民政救助保险支付
           "clinicCost": "BigDecimal",  <-- 诊疗项目费用
           "csSubsidyPayment": "BigDecimal", <-- 公务员医疗保险支付
           "drugCost": "BigDecimal", <-- 药品费用
           "entSupFundPayment": "BigDecimal",    <-- 企业补充基金支付
           "facilitiesCost": "BigDecimal", <-- 服务设施费用
           "insuranceKind": "string",    <-- 险种类型
           "materialCost": "BigDecimal", <-- 单独支付材料总费用
           "materialCostFee": "BigDecimal",    <-- 单独支付材料总费用
           "miPrivateAccountPayment": "BigDecimal",    <-- 医保个人账户支付
           "miSocialPoolingPayment": "BigDecimal",   <-- 医保统筹支付
           "ownExpenseFee": "BigDecimal",  <-- 自费金额（丙类费用）
           "payDt": "string",      <-- 赔付时间
           "payee": "string",          <-- 赔付对象
           "payeeCode": "string",          <-- 赔付对象编码
           "personType": "string",           <-- 医疗人员类别
           "seriousIllness": "BigDecimal",       <-- 进入大病费用(住院)
           "subsistenceSecurityPayment": "BigDecimal",   <-- 低保补助
           "totalPayment": "BigDecimal",         <-- 医疗总费用
           "twoAllowance": "BigDecimal",         <-- 二次补助(自付封顶补助)
           "visitNo": "string",                  <-- 就诊流水号
           "perSupFundPayment": 0 ,                  <-- 个人基金账户支付
         },
       ...                            <-- 其他医保付费信息
       ]
  },
  ...                            <-- 其他门诊明细信息
]
```

#### 2.17. 获取单次就诊所有明细信息

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取单次就诊所有明细信息。

**URL** : `/api/v1/health/person/medical-record`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
  "visitNo": "string",      <-- 就诊流水号
  "type": 0,                <-- 门诊/住院，1：门诊，2：住院
  "medicalKind": "string",  <-- 医疗类别
  "medicalKindCode": "string",  <-- 医疗类别编码
  "admDate": "date",        <-- 门诊的就诊日期，住院的入院日期
  "disDate": "date",        <-- 出院日期
  "medOrgName": "string",   <-- 医疗机构
  "medOrgCode":"String"		<-- 医疗机构编码
  "medOrgLvl": "string",    <-- 医疗机构等级
  "department": "string",   <-- 科室
  "doctor": "string",       <-- 医生
  "inHosDays": "string",    <-- 住院天数
  "drgsCode": "string",     <-- DRGs分组编码
  "drgsName": "string",     <-- DRGs分组名称
  "diagnoses": [            <-- 就诊诊断
  {
    "icdCode": "string",  <-- ICD诊断编码
    "icdName": "string",  <-- ICD诊断名称
    "isPrincipal": false, <-- 是否主诊断，true：主诊断，false：非主诊断
    "typeCode": "string",     <-- 诊断类别编码
    "typeName": "string",     <-- 诊断类别名称
    "order": 0,           <-- 诊断顺位
  },
  ...                     <-- 其他诊断结果
  ],
  "homepage":{
               "medOrgName": "string",        <-- 医疗机构名称
               "orgLicNo": "string",          <-- 组织机构代码
               "paymentWay": "string",        <-- 医疗费用支付方式
               "inHosTimes": "string",        <-- 住院次数
               "healthCardNo": "string",      <-- 居民健康卡号
               "insurCardNo": "string",       <-- 医保卡号
               "visitNo": "string",           <-- 就诊流水号
               "medRecordNo": "string",       <-- 病案号
               "name": "string",              <-- 姓名
               "gender": "string",            <-- 性别
               "age": 0,                      <-- 年龄
               "birthday": "date",            <-- 出生日期
               "country": "string",           <-- 国籍
               "nativeplace": "string",       <-- 籍贯
               "nation": "string",            <-- 民族
               "ageMonths": 0,                <-- 月龄
               "birthWeight": 0,              <-- 新生儿出生体重(g)
               "admWeight": 0,                <-- 新生儿入院体重(g)
               "idType": "string",            <-- 证件类型
               "idCardNo": "string",          <-- 证件号码
               "occupation": "string",        <-- 职业类别
               "marStatus": "string",         <-- 婚姻状况
               "address": "string",           <-- 现住址
               "telephone": "string",         <-- 联系电话
               "registry": "string",          <-- 户口
               "unitName": "string",          <-- 工作单位名称
               "unitAddr": "string",          <-- 工作单位地址
               "unitPhone": "string",         <-- 工作单位电话号码
               "contName": "string",          <-- 联系人姓名
               "contAddr": "string",          <-- 联系人地址
               "contPhone": "string",         <-- 联系人电话号码
               "relationship": "string",      <-- 联系人与患者的关系
               "admWays": "string",           <-- 入院途径
               "admDate": "string",           <-- 入院日期
               "admDept": "string",           <-- 入院科室
               "admWard": "string",           <-- 入院病房
               "refDept": "string",           <-- 转科科室
               "disDate": "string",           <-- 出院日期
               "disDept": "string",           <-- 出院科室
               "disWard": "string",           <-- 出院病房
               "inHosDays": "string",         <-- 住院天数
               "clinDiagCode": "string",      <-- 门(急)诊诊断名称
               "clinDiagName": "string",      <-- 门(急)诊诊断编码
               "poisonReason": "string",      <-- 损伤中毒的外部原因
               "pathDiagCode": "string",      <-- 病理诊断编码
               "pathDiagName": "string",      <-- 病理诊断名称
               "pathologyNo": "string",       <-- 病理号
               "isAllergy": false,            <-- 是否药物过敏
               "allergyDrug": "string",       <-- 过敏药物
               "isAutopsy": false,            <-- 是否死亡患者尸检
               "aboBlood": "string",          <-- ABO血型
               "rhBlood": "string",           <-- Rh血型
               "director": "string",          <-- 科主任
               "chiefPhy": "string",          <-- 主任(副主任)医师
               "phyInCha": "string",          <-- 主治医师
               "resident": "string",          <-- 住院医师
               "prNurse": "string",           <-- 责任护士
               "trainee": "string",           <-- 进修医师
               "medic": "string",             <-- 实习医师
               "coder": "string",             <-- 病案编码员
               "qc": "string",                <-- 病案质量
               "qcDoctor": "string",          <-- 质控医师
               "qcNurse": "string",           <-- 质控护士
               "qcDate": "string",            <-- 质控日期
               "outway": "string",            <-- 离院方式
               "recHos": "string",            <-- 拟接收医疗机构
               "disSituation": "string",      <-- 出院情况
               "rescueTimes": 0,              <-- 抢救次数
               "succResTimes": 0,             <-- 抢救成功次数
               "isClinPathway": false,        <-- 是否实施临床路径
               "isCmTechUsed": false,         <-- 是否使用中医技术
               "isDialNursUsed": false,       <-- 是否辨证施护
               "isReadmission": false,        <-- 是否出院31天内再住院
               "readmPurpose": "string",      <-- 出院31天内再住院目的
               "ptaComaDuration": "string",   <-- 颅脑损伤患者入院前昏迷时间
               "paComaDuration": "string",    <-- 颅脑损伤患者入院后昏迷时间
               "diagAccRateOpAndIp": "string",       <-- 诊断符合情况-门诊与住院
               "diagAccRateAdmAndDis": "string",     <-- 诊断符合情况-入院与出院
               "diagAccRatePreOpAndPostOp": "string",<-- 诊断符合情况-术前与术后
               "diagAccRateCliAndPat": "string",     <-- 诊断符合情况-临床与病理
               "diagAccRateRadAndPat": "string",     <-- 诊断符合情况-放射与病理
               "cmDiagnosis": "string",       <-- 门（急）诊诊断（中医诊断）
               "cmSymptom": "string",         <-- 门（急）诊诊断（中医证候）
               "isMedInsCmDrugUsed": false,   <-- 是否使用医疗机构中药制剂
               "isCmDiagEquipUsed": false,    <-- 是否使用中医诊疗设备
               "birthplaceProvince": "string",         <-- 出生地_省
               "birthplaceCity": "string",         <-- 出生地_市(地区、州)
               "birthplaceCounty": "string",         <-- 户口地址-县（区）
               "nativeplaceProvince": "string",         <-- 籍贯_省(区、市
               "nativeplaceCity": "string",         <-- 籍贯_市
               "contactsPhone": "string",         <-- 联系人电话
  },
  "summary" : {
              "admSituation": "string",      <-- 入院情况
              "admDiagnosis": "string",      <-- 入院诊断
              "treatProcess": "string",      <-- 诊疗经过及结果
              "disSituation": "string",      <-- 出院情况
              "disDiagnosis": "string",      <-- 出院诊断
              "disAdvice": "string",         <-- 出院医嘱
              "recorder": "string",          <-- 记录医师
  },
  "emrDiags":[
                {
                  "code": "string",            <-- 疾病诊断编码
                  "name": "string",            <-- 疾病诊断名称
                  "parimary": false,           <-- 是否主诊断
                  "order": "string",           <-- 诊断顺位
                },
                ...                            <-- 其他病案首页诊断信息
  ],
  "emrOpers":[
               {
                 "code": "string",            <-- 手术及操作编码
                 "name": "string",            <-- 手术操作名称
                 "operDt": "datetime",        <-- 手术操作日期时间
                 "level": "string",           <-- 手术级别
                 "incision": "string",        <-- 手术切口类别
                 "intention": "string",       <-- 切口愈合等级
                 "surgeon": "string",         <-- 手术医生
                 "anesthetist": "string",     <-- 麻醉师
                 "assistant1": "string",      <--ⅰ助姓名
                 "assistant2": "string",      <--ⅱ助姓名
               },
               ...                            <-- 其他病案首页手术操作信息
  ],
  "bills" : [
    {
      "billNo" : "string",                     <-- 单据号
      "items" :[
                 {
                   "billNo": "string",         <-- 单据号
                   "presNo": "string",         <-- 处方号
                   "presDt": "datetime",       <-- 处方日期时间
                   "accountingDt": "datetime", <-- 医院结算日期
                   "categoryCode": "string",   <-- 项目类别代码
                   "categoryName": "string",   <-- 项目类别名称
                   "code": "string",           <-- 收费项目代码
                   "name": "string",           <-- 收费项目名称
                   "spec": "string",           <-- 规格     
                   "amount": 0,                <-- 数量
                   "unit": "string",           <-- 单位
                   "price": "string",          <-- 单价
                   "chargeLevel": "string",    <-- 收费项目等级
                   "fee": 0,                   <-- 金额
                   "manufacture": "string",    <-- 生产企业名称
                   "maxPrice": "string",       <-- 限价
                   "condition": "string",      <-- 限药
                   "zliFee": 0                 <-- 自理金额
                   "zfeFee": 0,                <-- 自费金额
                   "elpZfuFee": 0,             <-- 超限价自付金额
                   "zfuPer": 0,                <-- 自付比例
                   "socPooZliFee": 0,          <-- 统筹自理
                   "consZliFee": 0,            <-- 大额自理
                   "consZfuPer": 0,            <-- 大额自付比例
                   "exConApLClsBZliFee": 0,    <-- 超大额封顶以上乙类自理
                   "exConApLZfuPer": 0,        <-- 超大额封顶线以上自付比例
                 },
                 ...                           <-- 其他费用明细记录
               ]
    },
    ...                           <-- 其他账单记录
  ],
  "reports" : [
      {
        "specNo": "string",          <-- 检验标本号
        "personName": "string",      <-- 患者姓名
        "gender": "string",          <-- 性别
        "age": "int",                <-- 年龄
        "specDt": "datetime",        <-- 接收标本的日期时间
        "specKind": "string",        <-- 标本类别
        "specStatus": "string",      <-- 标本状态
        "clinDiag": "string",        <-- 临床诊断
        "projects": [                <-- 检验
          {
            "testName": "string",    <-- 检验方法
            "testDt": "datetime",    <-- 检验日期
            "physician": "string",   <-- 检验医生
            "testNo": "string",      <-- 检验报告单编号
            "memo": "string",        <-- 检验报告备注
            "items": [               <-- 检验项目
              {
                "no": "string",      <-- 检验项目序号
                "code": "string",    <-- 检验项目代码
                "name": "string",    <-- 检验项目名称
                "result": "string",  <-- 检验结果
                "refVal": "string",  <-- 参考值
                "unit": "string",    <-- 单位
                "sign": "string",    <-- 指标异常
              },
              ...                    <-- 其他检验项目
            ],
          },
          ...                        <-- 其他检验
        ],
      },
      ...                            <-- 其他检验报告
  ],
  "exams":[
    {
      "appFormNo": "string",       <-- 电子申请单编号
      "specDt": "datetime",        <-- 送检日期
      "specKind": "string",        <-- 标本类别
      "specStatus": "string",      <-- 标本状态
      "specNo": "string",          <-- 检查标本号
      "examPart": "string",        <-- 检查部位
      "type": "string",            <-- 检查类型
      "complaint": "string",       <-- 主诉
      "symptom": "string",         <-- 症状描述
      "specFixative": "string",    <-- 标本固定液
      "process": "string",         <-- 诊疗过程描述
      "reportNo": "string",        <-- 检查报告单编号
      "objReport": "string",       <-- 检查报告结果-客观所见
      "subReport": "string",       <-- 检查报告结果-主观提示
      "memo": "string",            <-- 检查报告备注
      "reportDt": "datetime",      <-- 检查报告日期时间
      "itemName": "string",        <-- 检查项目名称
      "itemResult": "string",      <-- 检查项目结果
      "ultraImgReport": "string",  <-- 影像与超声检查
      "examinationPerson": "string",        <-- 审核医师
      "reportPerson": "string",      <-- 报告医师
      "clinicalDiagnosis": "string",  <-- 临床诊断
    },
    ...                            <-- 其他检查记录
  ],
  "advices" : [
    {
      "adviceDt": "datetime",      <-- 下达医嘱的日期时间
      "items": [                   <-- 医嘱项目
        {
          "adviceNo": "string",    <-- 医嘱流水号      
          "code": "string",        <-- 医嘱项目编码
          "name": "string",        <-- 医嘱项目名称
          "type": "string",        <-- 医嘱项目类别
          "dose": "string",        <-- 每次用量
          "unit": "string",        <-- 剂量单位
          "total": "string",       <-- 总量
          "daily": "string",       <-- 日频次
          "freq": "string",        <-- 使用频次
          "usage": "string",       <-- 用法
          "miniDose": "string",    <-- 最小剂量
          "miniDoseUnit": "string",<-- 最小剂量单位
          "groupId": "string",     <-- 组合号
          "startDt": "datetime",   <-- 医嘱开始执行的日期时间
          "startDoctor": "string", <-- 开始医生
          "startNurse": "string",  <-- 开始护士
          "stopDt": "datetime",    <-- 医嘱停止的日期时间
          "stopDoctor": "string",  <-- 停止医生        
          "stopExecDt": "datetime",<-- 停止执行时间
          "stopNurse": "string",   <-- 停止护士
          "isLongAdvice": false,   <-- 是否长期医嘱，true：长期医嘱，false：一般医嘱
          "isValuation": false,    <-- 是否计价，true：计价，false：不计价
          "isInvalid": false,      <-- 医嘱是否作废，true：作废，false：正常        
        },
        ...                        <-- 其他医嘱项目
      ],
    },
    ...                            <-- 其他医嘱
  ],
  "operations" : [
       {
         "no": "string",              <-- 手术编号
         "name": "string",            <-- 手术名称
         "opeDt": "datetime",         <-- 手术日期时间
         "opeLvl": "string",          <-- 手术级别
         "opePos": "string",          <-- 手术体位
         "opeHis": "string",          <-- 手术史标志
         "aob": "string",             <-- 出血量
         "aot": "string",             <-- 输血量
         "plcPos": "string",          <-- 放置部位
         "incision": "string",        <-- 手术切口描述
         "premedicate": "string",     <-- 术前用药
         "damName": "string",         <-- 引流材料名称
         "damAmount": "string",       <-- 引流材料数目
         "before": "string",          <-- 术前诊断
         "after": "string",           <-- 术后诊断
         "process": "string",         <-- 过程描述
         "anesthesia": "string",      <-- 麻醉方式
         "surgeon": "string",         <-- 手术医生
         "analgesist": "string",      <-- 麻醉师
         "assistants": "string",      <-- 手术助手
         "startTime":"string",		 <-- 手术开始时间
         "endTime":"string"		     <-- 手术结束时间
       },
       ...                            <-- 其他手术记录
 ],
 "drugs" : [
     {
       "billNo": "string",          <-- 单据号
       "presNo": "string",          <-- 处方号
       "presDt": "datetime",        <-- 处方日期时间
       "categoryCode": "string",    <-- 项目类别代码
       "categoryName": "string",    <-- 项目类别名称
       "hItemCode": "string",       <-- 医院收费项目代码
       "mItemCode": "string",       <-- 付费方收费项目代码
       "name": "string",            <-- 收费项目名称
       "spec": "string",            <-- 规格     
       "amount": "double",          <-- 数量
       "unit": "string",            <-- 单位
       "price": "string",           <-- 单价
       "chargeLevel": "string",     <-- 收费项目等级
       "fee": 0,                    <-- 金额
       "manufacture": "string",     <-- 生产企业名称
       "drugApprovalNo": "string",  <-- 药品批准文号
       "otc": "string",             <-- OTC标识
       "executionTime": "string",   <-- 执行日期
     },
     ...                            <-- 其他使用药品
  ],
  "items" : [
      {
        "billNo": "string",          <-- 单据号
        "presNo": "string",          <-- 处方号
        "presDt": "datetime",        <-- 处方日期时间
        "categoryCode": "string",    <-- 项目类别代码
        "categoryName": "string",    <-- 项目类别名称
        "hItemCode": "string",       <-- 医院收费项目代码
        "mItemCode": "string",       <-- 付费方收费项目代码
        "name": "string",            <-- 收费项目名称
        "spec": "string",            <-- 规格     
        "amount": 0,                 <-- 数量
        "unit": "string",            <-- 单位
        "price": "string",           <-- 单价
        "chargeLevel": "string",     <-- 收费项目等级
        "fee": 0,                    <-- 金额
        "manufacture": "string",     <-- 生产企业名称
        "ceilingPrice": "string",	 <-- 最高限价
      },
      ...                            <-- 其他诊疗项目
  ],
  "payInfos": [
      {
        "biPayment": "BigDecimal",  <-- 商保支付
        "billNo": "string",   <-- 单据号
        "cashPayment": "BigDecimal",  <-- 现金支付
        "catastrophicDiseasePayment": "BigDecimal",   <-- 大病支付
        "civilReliefFundPayment": "BigDecimal",   <-- 民政救助保险支付
        "clinicCost": "BigDecimal",  <-- 诊疗项目费用
        "csSubsidyPayment": "BigDecimal", <-- 公务员医疗保险支付
        "drugCost": "BigDecimal", <-- 药品费用
        "entSupFundPayment": "BigDecimal",    <-- 企业补充基金支付
        "facilitiesCost": "BigDecimal", <-- 服务设施费用
        "insuranceKind": "string",    <-- 险种类型
        "materialCost": "BigDecimal", <-- 单独支付材料总费用
        "materialCostFee": "BigDecimal",    <-- 单独支付材料总费用
        "miPrivateAccountPayment": "BigDecimal",    <-- 医保个人账户支付
        "miSocialPoolingPayment": "BigDecimal",   <-- 医保统筹支付
        "ownExpenseFee": "BigDecimal",  <-- 自费金额（丙类费用）
        "payDt": "string",      <-- 赔付时间
        "payee": "string",          <-- 赔付对象
        "payeeCode": "string",          <-- 赔付对象编码
        "personType": "string",           <-- 医疗人员类别
        "seriousIllness": "BigDecimal",       <-- 进入大病费用(住院)
        "subsistenceSecurityPayment": "BigDecimal",   <-- 低保补助
        "totalPayment": "BigDecimal",         <-- 医疗总费用
        "twoAllowance": "BigDecimal",         <-- 二次补助(自付封顶补助)
        "visitNo": "string"                   <-- 就诊流水号
        "perSupFundPayment": 0,                  <-- 个人基金账户支付
      },
    ...                            <-- 其他医保付费信息
    ]
}
```

### 3. 保险业务服务

#### 3.1. 获取个人参保信息最后一条有效记录

通过证件类型、证件号码和姓名，获取此人的参保信息，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/insurance/person/insurant`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
    {
      "kind": 0,                   <-- 保险种类，1：医保，2：商保
      "insuranceName": "string",   <-- 保险种类识别名，医保的统筹区名称或商保的保险公司名称
      "insuranceCode": "string",   <-- 医保的统筹区编码或商保的保险公司编码
      "insuredPersonNo": "string", <-- 参保人编号，医保个人编号或商保客户号
      "isCivilServant": "string",  <-- 是否公务员，true：公务员，false：非公务员
      "personType": "string",      <-- 人员类别
      "insuranceKind": "string",   <-- 险种类型（医保）
      "insuredStatus": "string",   <-- 参保状态（医保）
      "firstInsuredYm": "string",  <-- 首次参保年月（医保）
      "insuredDate": "string",     <-- 本次参保日期（医保）
      "insuredCompany": "string",  <-- 参保单位（医保）
    },
    ...                            <-- 其他参保信息
]
```

#### 3.2. 获取个人医保账户余额

通过证件类型、证件号码和姓名，获取此人的医保账户余额，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/insurance/person/balance`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：医保账户余额

#### 3.3. 获取医保就诊赔付明细

通过证件类型、证件号码和姓名，获取此人的医保就诊赔付明细数据，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

可以通过设置赔付日期范围，约束返回的结果集。

**URL** : `/api/v1/insurance/person/pay-journal`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **start** | _string_ | _否_ | `null` | **赔付日期范围（开始）**，格式：`yyyyMMdd`，条件为大于等于。 |
| **end** | _string_ | _否_ | `null` | **赔付日期范围（结束）**，格式：`yyyyMMdd`，条件为小于等于。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
    {
      "visitNo": "string",             <-- 就诊流水号
      "billNo": "string",              <-- 单据号
      "payDt": "datetime",             <-- 赔付时间
      "insuranceKind": "string",       <-- 险种类型
      "payeeCode": "string",           <-- 赔付对象编码
      "payee": "string",               <-- 赔付对象
      "totalPayment": 0,               <-- 医疗总费用
      "miSocialPoolingPayment": 0,     <-- 医保统筹支付
      "miPrivateAccountPyament": 0,    <-- 医保个人账户支付
      "biPyament": 0,                  <-- 商保支付
      "cashPayment": 0,                <-- 现金支付
      "civilReliefFundPayment": 0,     <-- 民政救助保险支付
      "csSubsidyPayment": 0,           <-- 公务员医疗保险支付
      "entSupFundPayment": 0,          <-- 企业补充基金支付
      "catastrophicDiseasePayment": 0, <-- 大病支付
      "subsistenceSecurityPayment": 0, <-- 低保补助
      "drugCost": 0,                   <-- 药品费用
      "clinicCost": 0,                 <-- 诊疗项目费用
      "facilitiesCost": 0,             <-- 服务设施费用
      "ownExpenseFee": 0,              <-- 自费金额（丙类费用）
      "materialCostFee": 0,            <-- 单独支付材料总费用
      "personType": "string",          <-- 人员类别代码
      "twoAllowance": 0,               <-- 二次补助(自付封顶补助)
      "seriousIllness": 0              <-- 进入大病费用(住院)
      "materialCost": 0                <-- 单独支付材料总费用
      "perSupFundPayment": 0 ,                  <-- 个人基金账户支付
    },
    ...                                <-- 其他医保就诊赔付信息
]
```

#### 3.4. 获取医保就诊付费明细信息

通过保险公司编号（或医保统筹区编号）、医疗机构编号和就诊流水号，获取此次就诊的付费明细信息。

**URL** : `/api/v1/insurance/person/pay-detail`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
    "billNo": "string",         <-- 单据号
    "presNo": "string",         <-- 处方号
    "presDt": "datetime",       <-- 处方日期时间
    "accountingDt": "datetime", <-- 医院结算日期
    "categoryCode": "string",   <-- 项目类别代码
    "categoryName": "string",   <-- 项目类别名称
    "code": "string",           <-- 收费项目代码
    "name": "string",           <-- 收费项目名称
    "spec": "string",           <-- 规格     
    "amount": 0,                <-- 数量
    "unit": "string",           <-- 单位
    "price": "string",          <-- 单价
    "chargeLevel": "string",    <-- 收费项目等级
    "fee": 0,                   <-- 金额
    "manufacture": "string",    <-- 生产企业名称
    "maxPrice": "string",       <-- 限价
    "condition": "string",      <-- 限药
    "zliFee": 0                 <-- 自理金额
    "zfeFee": 0,                <-- 自费金额
    "elpZfuFee": 0,             <-- 超限价自付金额
    "zfuPer": 0,                <-- 自付比例
    "socPooZliFee": 0,          <-- 统筹自理
    "consZliFee": 0,            <-- 大额自理
    "consZfuPer": 0,            <-- 大额自付比例
    "exConApLClsBZliFee": 0,    <-- 超大额封顶以上乙类自理
    "exConApLZfuPer": 0,        <-- 超大额封顶线以上自付比例
    "hCode": "string",        <-- 价项院内代码
    "hName": "string",        <-- 价项院内名称
  },
  ...                           <-- 其他费用明细记录
]
```

#### 3.5. 获取医保就诊赔付的明细信息

通过证件类型、证件号码和姓名，获取此人的医保就诊赔付明细信息，其中姓名是可选项。

**URL** : `/api/v1/insurance/person/visit-pay-journal`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |
| **hos** | _string_ | **是** | - | **医疗机构编号** |
| **no** | _string_ | **是** | - | **就诊流水号** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
    {
        "visitNo": "string",             <-- 就诊流水号
        "billNo": "string",              <-- 单据号
        "payDt": "datetime",             <-- 赔付时间
        "insuranceKind": "string",       <-- 险种类型
        "payeeCode": "string",           <-- 赔付对象编码
        "payee": "string",               <-- 赔付对象
        "totalPayment": 0,               <-- 医疗总费用
        "miSocialPoolingPayment": 0,     <-- 医保统筹支付
        "miPrivateAccountPyament": 0,    <-- 医保个人账户支付
        "biPyament": 0,                  <-- 商保支付
        "cashPayment": 0,                <-- 现金支付
        "civilReliefFundPayment": 0,     <-- 民政救助保险支付
        "csSubsidyPayment": 0,           <-- 公务员医疗保险支付
        "entSupFundPayment": 0,          <-- 企业补充基金支付
        "catastrophicDiseasePayment": 0, <-- 大病支付
        "subsistenceSecurityPayment": 0, <-- 低保补助
        "drugCost": 0,                   <-- 药品费用
        "clinicCost": 0,                 <-- 诊疗项目费用
        "facilitiesCost": 0,             <-- 服务设施费用
        "ownExpenseFee": 0,              <-- 自费金额（丙类费用）
        "materialCostFee": 0,            <-- 单独支付材料总费用
        "personType": "string",          <-- 人员类别代码
        "twoAllowance": 0,               <-- 二次补助(自付封顶补助)
        "seriousIllness": 0              <-- 进入大病费用(住院)
        "materialCost": 0                <-- 单独支付材料总费用
        "perSupFundPayment": 0 ,                  <-- 个人基金账户支付
        "subsectionOneself": 0 ,                  <-- 统筹分段自付
        "classbOneself": 0 ,                  <-- 乙类自理费用
        "exceedLimitOneself": 0 ,                  <-- 超限价自付费用
        "qfStandardOneself": 0 ,                  <-- 起付标准自付
        "accordWithBm": 0 ,                  <-- 符合基本医疗费用
        "invalidismFund": 0 ,                  <-- 伤残保障基金
        "otherFund": 0 ,                  <-- 其他基金
    },
     ...                                  <-- 其他医保赔付信息
]
```

#### 3.6. 获取个人所有参保信息

通过证件类型、证件号码和姓名，获取此人的参保信息，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/insurance/person/insurants`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
    {
      "kind": 0,                   <-- 保险种类，1：医保，2：商保
      "insuranceName": "string",   <-- 保险种类识别名，医保的统筹区名称或商保的保险公司名称
      "insuranceCode": "string",   <-- 医保的统筹区编码或商保的保险公司编码
      "insuredPersonNo": "string", <-- 参保人编号，医保个人编号或商保客户号
      "isCivilServant": "string",  <-- 是否公务员，true：公务员，false：非公务员
      "personType": "string",      <-- 人员类别
      "insuranceKind": "string",   <-- 险种类型（医保）
      "insuredStatus": "string",   <-- 参保状态（医保）
      "firstInsuredYm": "string",  <-- 首次参保年月（医保）
      "insuredDate": "string",     <-- 本次参保日期（医保）
      "insuredCompany": "string",  <-- 参保单位（医保）
      "insuranceEndDate": "string" <-- 停保日期（医保）
    },
    ...                            <-- 其他参保信息
]
```

#### 3.7. 获取指定医保号的参保人员信息

通过医保编号、统筹区域编码，获取此人的基本信息。

**URL** : `/api/v1/insurance/person/info`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **医保编号**，例：`1002370254` |
| **region** | _string_ | **是** | - | **保险公司编号（或医保统筹区编号）** |

**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
{
    "idTypeCode": "string",     <-- 证件类型代码
    "idTypeName": "string",     <-- 证件类型名称
    "idCardNo": "string",       <-- 证件号码
    "name": "string",           <-- 姓名
}
```

### 4. 文件服务

#### 4.1. 获取个人照片

通过证件类型、证件号码和姓名，获取此人的电子照片，其中姓名是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/file/person/photo`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |

**返回数据**

> HTTP状态码：200
> HTTP内容：raw data

```http
HTTP/1.1 200 OK 
Content-Type: image/jpeg

......PHTOT DATA......
```
### 5. 药店服务

#### 5.1. 获取个人历史购药记录详细信息

通过证件类型、证件号码和姓名，药店结算日期开始、结束时间范围获取此人的购药历史记录详细信息，其中姓名、证件类型、药店结算日期开始、结束时间范围是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/store/person/drugs`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **start** | _string_ | _否_ | `null` | **药店结算日期范围（开始）**，格式：`yyyyMMdd`，条件为大于等于。 |
| **end** | _string_ | _否_ | `null` | **药店结算日期范围（结束）**，格式：`yyyyMMdd`，条件为小于等于。 |
**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json
[
  {
  "personId": "string",                 <-- 自然人ID
  "insuredPersonNo": "string",          <-- 参保人编号（医保个人编号/商保客户号）
  "insuranceCode": "string",            <-- 保险公司编号（医保的统筹区/商保的保险公司编号）
  "medOrgCode": "string",               <-- 医疗机构编码
  "visitNo": "string",                  <-- 就诊流水号
  "billNo": "string",                   <-- 单据号
  "presNo": "string",                   <-- 处方号
  "refundNo": "string",                 <-- 退费流水号
  "approvalNo": "string" ,              <-- 批准文号
  "presDt": "string",                 <-- 处方日期时间
  "accountingDt": "string",           <-- 药店结算日期时间
  "clz2Code": "string",                 <-- 药品二级分类编码
  "hItemCode": "string",                <-- 医院收费项目代码
  "mItemCode": "string",                <-- 付费方收费项目代码
  "name": "string",                     <-- 收费项目名称
  "chargeLevel": "string",              <-- 收费项目等级
  "transType": "string",                <-- 交易类型
  "price": "string",                    <-- 单价
  "spec": "string",                     <-- 规格
  "dosageForm": "string",               <-- 剂型
  "amount": 0,                          <-- 数量
  "unit": "string",                     <-- 单位
  "fee": 0,                             <-- 金额
  "zliFee": 0                           <-- 自理金额
  "zfeFee": 0,                          <-- 自费金额
  "maxPrice": "string",                 <-- 限价
  "elpZfuFee": 0,                       <-- 超限价自付金额
  "zfuPer": 0,                          <-- 自付比例
  "socPooZliFee": 0,                    <-- 统筹自理
  "consZliFee": 0,                      <-- 大额自理
  "consZfuPer": 0,                      <-- 大额自付比例
  "exConApLClsBZliFee": 0,              <-- 超大额封顶以上乙类自理
  "exConApLZfuPer": 0,                  <-- 超大额封顶线以上自付比例
  }
  ...                                   <-- 其他购药记录
]
```

#### 5.2. 获取个人历史购药记录

通过证件类型、证件号码和姓名，购药日期开始、结束时间范围获取此人的购药历史记录，其中姓名、证件类型、购药日期开始、结束时间范围是可选项，证件默认为中华人民共和国居民身份证。

**URL** : `/api/v1/store/person/drugs`

**Method** : `GET`

**参数**

| 名称 | 数据类型 | 必须 | 缺省值 | 说明 |
| --- | ------- | --- | ----- | ---- |
| **no** | _string_ | **是** | - | **证件号码**，例：`210102200001012075` |
| **type** | _int_ | _否_ | `1` | **证件类型**，缺省为中国居民身份证，值为 `1` |
| **name** | _string_ | _否_ | `null` | **姓名**，URL编码后的字符串，例：王大帅，编码后为 `%E7%8E%8B%E5%A4%A7%E5%B8%85`。当姓名为空时，通过证件号码和证件类型来查找此人的信息。 |
| **start** | _string_ | _否_ | `null` | **购药日期范围（开始）**，格式：`yyyyMMdd`，条件为大于等于。 |
| **end** | _string_ | _否_ | `null` | **购药日期范围（结束）**，格式：`yyyyMMdd`，条件为小于等于。 |
**返回数据**

> HTTP状态码：200
> HTTP内容：json

```json

{
  "personId": "string",                 <-- 自然人ID
  "insuredPersonNo": "string",          <-- 参保人编号（医保个人编号/商保客户号）
  "insuranceCode": "string",            <-- 保险公司编号（医保的统筹区/商保的保险公司编号）
  "medOrgCode": "string",               <-- 医疗机构编码
  "medOrgName": "string",               <-- 医疗机构名称
  "visitNo": "string",                  <-- 就诊流水号
  "drugDate": "string",                  <-- 购药时间
  "name": "string",                   <-- 姓名
  "idCardNo": "string",                  <-- 身份证号
  "drugRecordBills":
  [
    {
    "personId": "string",                 <-- 自然人ID
    "insuredPersonNo": "string",          <-- 参保人编号（医保个人编号/商保客户号）
    "insuranceCode": "string",            <-- 保险公司编号（医保的统筹区/商保的保险公司编号）
    "medOrgCode": "string",               <-- 医疗机构编码
    "visitNo": "string",                  <-- 就诊流水号
    "billNo": "string",                   <-- 单据号
    "presNo": "string",                   <-- 处方号
    "refundNo": "string",                 <-- 退费流水号
    "approvalNo": "string" ,              <-- 批准文号
    "presDt": "string",                 <-- 处方日期时间
    "accountingDt": "string",           <-- 药店结算日期时间
    "clz2Code": "string",                 <-- 药品二级分类编码
    "hItemCode": "string",                <-- 医院收费项目代码
    "mItemCode": "string",                <-- 付费方收费项目代码
    "name": "string",                     <-- 收费项目名称
    "chargeLevel": "string",              <-- 收费项目等级
    "transType": "string",                <-- 交易类型
    "price": "string",                    <-- 单价
    "spec": "string",                     <-- 规格
    "dosageForm": "string",               <-- 剂型
    "amount": 0,                          <-- 数量
    "unit": "string",                     <-- 单位
    "fee": 0,                             <-- 金额
    "zliFee": 0                           <-- 自理金额
    "zfeFee": 0,                          <-- 自费金额
    "maxPrice": "string",                 <-- 限价
    "elpZfuFee": 0,                       <-- 超限价自付金额
    "zfuPer": 0,                          <-- 自付比例
    "socPooZliFee": 0,                    <-- 统筹自理
    "consZliFee": 0,                      <-- 大额自理
    "consZfuPer": 0,                      <-- 大额自付比例
    "exConApLClsBZliFee": 0,              <-- 超大额封顶以上乙类自理
    "exConApLZfuPer": 0,                  <-- 超大额封顶线以上自付比例
    }
    ...                                   <-- 其他购药记录
  ]
}

```