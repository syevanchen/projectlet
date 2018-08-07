# ngcp服务 RESTful API 规范

[TOC]

## 一、共通规范

### 1. URL 规范

#### 1.1. API 域和 DOC 域

数据服务接口使用`api`作为一级目录，文档使用`doc`作为一级目录。之后其他形式的服务需求可以依次补充。

```plain
https://<host:port>/api/... <-- 子域为API，返回数据是 json 形式
https://<host:port>/doc/... <-- 子域为文档，返回数据是 html 形式
```

#### 1.2. 版本域

本次发行为`v1`版本，今后陆续升级为`v2`、`v3`……

```plain
https://example.com/api/v1/... <-- 第一版 API
https://example.com/api/v2/... <-- 第二版 API
```

#### 1.3. 主题域

在版本域后依次是不同的主题域，例如，人的主题域`person`，其他主题域依次追加。

```plain
https://<host:port>/api/v1/person/...
```

### 2. HTTP 协议规范

#### 2.1. HTTP 动词

HTTP 动词含义如下，

 - GET：获取资源
 - POST：创建资源
 - PUT：更新资源
 - DELETE：删除资源

#### 2.2. HTTP 状态码

服务端通过返回不同的 HTTP 状态码来标识执行的结果。

#### 2.3. 主要状态码

 - **2xx** ：成功
 - **4xx** ：调用方错误
 - **5xx** ：服务端错误

#### 2.4. 调用失败的状态码

 - **400**：请求无效。一般是请求的数据格式错误；
 - **401**：请求的资源需要授权。服务端首先要验证调用方的身份才能继续处理请求；
 - **404**：请求不存在的资源；
 - **500**：服务端错误。

### 3. 数据载体规范

使用`json`作为数据载体，从统一数据载体的形式考虑，请求和响应均为JSON格式。

#### 3.1. 在 HTTP 头部明示数据载体

请求数据的头部明示数据载体，

```http
Accept: application/json
Content-Type: application/json
```

响应数据的头部明示数据载体，

```http
Content-Type: application/json
```

### 4. 数据内容规范

在返回数据外层封装一个`Response`对象，用来返回调用结果。`Response`对象如下，

```json
{
	"code": 0,  <-- 返回的状态代码，0 表示正常，其他数值表示错误类别
	"msg": "ok",<-- 返回的响应消息，"ok"表示正常，其他场合为错误消息
	"value": ...<-- 当正常返回时，此处为返回的数据，根据接口不同不同；错误场合，没有此项
}
```

#### 4.1. 数据日期和时间格式

规定日期格式为 `yyyy-MM-dd`，例如：`2018-01-22`；日期+时间的格式为 `yyyy-MM-dd hh:mm:ss`，例如：`2018-01-22 12:23:58`。

#### 4.2. 忽略空值

属性值为`null`的属性不会出现在返回值中。

### 5. 参数定义规范

#### 5.1 参数命名

##### 参数命名规范

采用Java变量命名规范（驼峰方式），如"个人信息"命名为`personInfo`

##### 特定参数名后缀

针对几种值为特定类型的参数，命名时要按照一下标准使用后缀名：

`Id`: 参数值为用于唯一标识别业务实体的无意义的字符串的参数，一般不作为BDAS服务的输入输出的参数项（由源业务系统生成的参数项目除外）

`No` : 参数值为业务号码格式的参数，如身份证号码`idNo` ，个人编号`personNo`

`Code` : 参数值为业务编码格式的参数，如疾病ICD编码，`icdCode`

`Name` : 输入输出的参数对象中有对应的代码项，但同时还有代码项对应的名称项时，名称参数采用`Name`作为参数项命名的 后缀。例如，参数对象中有药品代码参数项`drugCode`，则对应的药品名称参数项目就要命名为`drugName`。如果参数项不以`Code`或者`Name`为后缀，则该参数项缺省格式为名称，如`gender`对象的参数值应该为`男`或者`女`。

`Fee`: 参数值为费用金额的参数项，如现金支付金额`cashPayFee`。

`Amount`: 参数值为数量（整数）的参数项，如购买数量`purchaseAmount`

`Date`: 参数值为日期的参数项，如开始日期 `startDate`

`Time`: 参数值为时间的参数项，如创建时间`createTime`

## 二、业务词汇表

### 1. 医疗健康词汇表

|词汇  |别名 |英文    |英文缩写   |备注    |HCBD对应词汇   |
|:------------|:-----------|:------|:-----------|:----------|
|   编号  |   -   |   id  |   -   |   仅限用于每一个业务实体或表的内部唯一标识，无业务含义  |       |
|   编码  |   代码  |   code    |   cd  |   编码，并且对应有字典表翻译成name的 |       |
|   号码  |   -   |   no  |   -   |   号码，如：身份证号码ID_No,电话号码Phone_No    |       |
|   医院  |   -   |   hospital    |   hos |   -   |       |
|   剂量  |   -   |   dose    |   -   |   -   |       |
|   单位  |   -   |   unit    |   -   |   度量单位    |       |
|   最高限价    |   -   |   ceiling price   |   -   |   -   |       |
|   组织机构代码  |   -   |   organization license no |   -   |   -   |       |
|   金额  |   -   |   fee |   -   |       |   money   |
|   费用  |       |   cost    |       |       |       |
|   支付  |       |   payment |       |       |       |
|   治疗  |   -   |   treatment   |   -   |   -   |       |
|   操作  |   -   |   operation   |   -   |   -   |       |
|   护理  |   -   |   nursing |   -   |   -   |       |
|   自费  |   自付、（费用）自理   |   own pay |   -   |   -   |   take care / oneself / own expense   |
|   转科科室    |   -   |   referral department |   -   |   -   |   change department   |
|   注射液 |   -   |   injection   |       |   -   |       |
|   住院  |   -   |   in hospital |   in_hos  |   -   |       |
|   主诉  |   主述  |   complaint   |   -   |   -   |   case main / chief complaint |
|   医生  |   医师  |   doctor  |       |       |       |
|   住院医师    |   -   |   resident physician  |   -   |   -   |   resident    |
|   主治医师    |   -   |   physician-in-charge |   -   |   -   |   physician   |
|   主任医师    |   -   |   chief physician |       |       |   archiater   |
|   副主任医师   |   -   |   associate chief physician   |       |       |       |
|   实习医师    |       |   medic   |       |       |       |
|   护士  |       |   nurse   |       |       |       |
|   责任护士    |   -   |   primary nurse   |       |       |       |
|   主管机构    |   主管部门    |   competent authority |       |       |   competent department    |
|   症候  |   症状  |   symptom |       |       |       |
|   症候群 |   -   |   syndrome    |       |       |       |
|   中医  |   -   |   chinese medicine    |       |       |       |
|   推拿  |       |   massage |       |       |       |
|   骨伤  |       |   orthopedics |       |       |       |
|   肛肠  |       |   anorectal   |       |       |       |
|   针灸  |       |   acupuncture |       |       |       |
|   辨证施膳    |       |   dialectical battels |       |       |       |
|   中药  |       |   chinese drug    |       |       |   herb    |
|   饮片  |       |   decocting pieces    |       |       |   herbal pieces   |
|   中成药 |       |   chinese patent drug |       |       |   chinese patent medicine |
|   中草药 |       |   chinese herbal drug |       |       |   chinese herbal medicine |
|   制剂  |       |   preparation |       |       |       |
|   管理办法    |       |   regulations |       |       |       |
|   麻醉  |       |   anesthesia  |       |       |       |
|   理疗  |       |   physical therapy    |       |       |       |
|   临床  |       |   clinic  |       |       |       |
|   质量控制    |   质控  |   quality control |   qc  |       |       |
|   职业  |       |   occupation  |       |       |       |
|   职能  |       |   function    |       |   或 functional    |       |
|   执业许可    |       |   practicing license  |       |       |   licensed practice   |
|   政府补贴    |       |   government subsidy  |       |       |       |
|   到账日期    |   入账日期    |   posting date    |       |       |   arrival date    |
|   大额保险    |       |   considerable insurance  |       |       |   large insurance |
|   证件  |       |   id  |       |       |       |
|   征收  |       |   levy    |       |       |   collection  |
|   诊疗项目    |       |   clinic item |       |       |       |
|   顺位  |       |   order   |       |       |       |
|   手术  |       |   operation   |       |       |       |
|   术前  |       |   preoperative    |       |       |       |
|   术后  |       |   post-operative  |       |       |       |
|   术中  |       |   intraoperative  |       |       |   in operation    |
|   手术者 |       |   surgeon |       |       |       |
|   门诊  |       |   outpatient  |       |       |       |
|   病理  |       |   pathology   |       |   或 pathological  |       |
|   放射  |       |   radiology   |       |       |       |
|   影像学 |       |   imageology  |       |   影像检查：imageological diagnosis    |       |
|   实验室 |       |   laboratory  |   lab |       |       |
|   医嘱  |       |   advice  |       |       |       |
|   用药天数    |       |   medication days |       |       |       |
|   应缴  |       |   payable |       |       |   should paid |
|   滞纳金 |       |   overdue fine    |       |       |   late fee    |
|   救助金 |       |   relief fund |       |       |   salvage money   |
|   补助金 |       |   subsidy |       |       |       |
|   公务员 |       |   civil servant   |       |       |       |
|   划入  |       |   credit  |       |   划入账户：credit for load    |       |
|   统筹  |   社会统筹    |   social pooling  |       |       |   overall |
|   医保统筹    |       |   social pooling for medical insurance    |       |       |   medical plan    |
|   大病统筹    |       |   social pooling for catastrophic disease |       |       |       |
|   跨年利息    |       |   cross-year interest |       |       |       |
|   本年利息    |       |   annual interest |       |       |       |
|   超声检查    |       |   ultrasonography |       |       |       |
|   引流  |       |   drainage    |       |       |       |
|   材料  |   耗材  |   consumables |       |   医用材料：medical consumables    |   meterial    |
|   异地  |       |   inter-regional  |       |       |   remote  |
|   已缴  |       |   paid-in |       |       |   already paid    |
|   甲类  |       |   class a |       |       |       |
|   乙类  |       |   class b |       |       |       |
|   丙类  |       |   class c |       |       |       |
|   保险  |       |   insurance   |       |       |       |
|   医保  |   医疗保险    |   medical insurance   |       |       |       |
|   信用等级    |       |   credit rating   |       |       |   credit grade    |
|   结算  |       |   settlement  |       |       |       |
|   医疗类别    |       |   medical kind    |       |       |       |
|   医疗机构    |       |   medical organization    |       |       |       |
|   缴费基数    |   社保缴费基数  |   social insurance base   |       |       |   paid base   |
|   药物  |       |   drug    |       |       |   medicine    |
|   过敏  |       |   allergy |       |       |       |
|   药厂  |   药品生产企业  |   drug manufacture    |       |       |       |
|   性别  |       |   gender  |       |       |       |
|   险种类型    |       |   insurance kind  |       |       |       |
|   退费  |       |   refund  |       |       |       |
|   特病  |       |   special disease |       |       |       |
|   疾病  |   病   |   disease |   -   |       |       |
|   电话  |   电话号码    |   telephone   |   tel |       |       |
|   地址  |       |   address |   addr    |       |       |
|   税号  |       |   duty paragraph  |       |       |   DUTY_PARAGRAPH  |
|   财政  |       |   finance |       |       |       |
|   缴费  |       |   payment |       |       |       |
|   起付标准    |   起付线 |   deductible  |       |       |       |
|   保单  |   保险单 |   insurance policy    |       |       |       |
|   保险产品    |       |   insurance product   |       |       |       |
|   保险计划    |       |   insurance plan  |       |       |       |
|   保险公司    |       |   insurance company   |       |       |       |
|   理赔员 |   保险理赔员   |   insurance actuary   |       |       |       |
|   定点  |       |   designated  |       |       |       |
|   定点药店    |       |   designated pharmacy |       |       |       |
|   药店  |       |   pharmacy    |       |       |   drugstore   |
|   付费方式    |       |   method of payment   |       |       |       |
|   参保  |       |   insured |       |       |       |
|   标本  |       |   specimen    |       |       |   sample  |
|   病案  |       |   medical record  |       |       |       |
|   诊断  |   诊疗  |   diagnosis   |       |       |       |
|   超限价 |       |   exceed limited price    |       |       |       |
|   入院  |       |   admission   |       |       |       |
|   出院  |       |   discharge   |       |       |       |
|   处方  |       |   prescription    |       |       |       |
|   大额  |       |   considerable    |       |       |       |
|   低保  |       |   subsistence security    |       |       |       |
|   付费方 |       |   payor   |       |       |       |
|   工商登记    |       |   business registration   |       |       |       |
|   工作单位    |   单位  |   work unit   |       |       |       |
|   户口  |   户籍  |   household   |       |       |       |
|   籍贯  |       |   native place    |       |       |       |
|   基本医疗保险  |       |   basic medical insurance |       |       |       |
|   种类  |   分类  |   category    |       |       |       |
|   类型  |       |   kind    |       |       |       |
|   类别  |       |   type    |       |       |       |
|   送检  |       |   submission  |       |       |       |
|   体位  |       |   position    |       |       |       |
|   切口  |       |   incision    |       |       |       |
|   收费项目    |       |   charge  |       |       |       |
|   适应症 |       |   indication  |       |       |       |
|   皮试  |       |   skin test   |       |       |       |
|   新生儿 |       |   newborn |       |       |       |
|   婴儿  |       |   baby    |       |       |       |
|   基本药物    |   基础药物    |   remedium basis  |       |       |       |
|   视同缴费    |       |   deemed payment  |       |       |       |
