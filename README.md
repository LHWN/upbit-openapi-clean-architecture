![header](https://capsule-render.vercel.app/api?type=wave&color=auto&height=200&section=header&text=Upbit%20OpenAPI&fontSize=90)
# 1. API 호출 및 DB 조회/생성
## [Step1] 내부에서 외부 Upbit API 호출
&nbsp;&nbsp;&nbsp;&nbsp;ㄴReqeust URL : http://localhost:8080/v1/market/all
<br/><br/>
<img width="1443" alt="image" src="https://user-images.githubusercontent.com/23093152/216809819-68c71586-3107-4692-aed4-222443d713f0.png">
<br/>
## [Step2] MySQL 데이터 조회
&nbsp;&nbsp;&nbsp;&nbsp;ㄴReqeust URL : http://localhost:8080/v1/repo/market/all
<br/><br/>
<img width="857" alt="image" src="https://user-images.githubusercontent.com/23093152/216809884-20c507ca-af01-4211-b5b9-fb2000965aec.png">
<br/>
## [Step3] Controller 에서 객체 임시로 생성해서 DB 에 저장
&nbsp;&nbsp;&nbsp;&nbsp;ㄴReqeust URL : http://localhost:8080/v1/test/save
<br/><br/>(Controller 에서 데이터 임시 생성)<br/>
<img width="606" alt="image" src="https://user-images.githubusercontent.com/23093152/216810027-d62cfd1f-2a07-4c05-af72-511205688348.png">
<br/>(MySQL 에 데이터 생성 확인)<br/>
<img width="674" alt="image" src="https://user-images.githubusercontent.com/23093152/216810040-199b8672-1528-4e5d-a90b-05fbd0719923.png">

## [Step4] List 형식의 다수 Market 을 DB 에 저장
&nbsp;&nbsp;&nbsp;&nbsp;ㄴReqeust URL : http://localhost:8080/v1/repo/market/save
<br/><br/>(List 형식의 다수 Market 을 Request Body 에 담아 POST 요청)<br/>
<img width="1073" alt="image" src="https://user-images.githubusercontent.com/23093152/216810085-71f6b7dc-3720-4a6c-b196-b900112dc6f5.png">
<br/>(MySQL 에 데이터 생성 확인)<br/>
<img width="652" alt="image" src="https://user-images.githubusercontent.com/23093152/216810109-6dabda13-4056-45cc-83ed-d47caf711343.png">

## [Step5] DB 에 저장되어 있는 모든 Markets 을 GET 으로 조회
&nbsp;&nbsp;&nbsp;&nbsp;ㄴReqeust URL : http://localhost:8080/v1/repo/market/all
<br/><br/><img width="1077" alt="image" src="https://user-images.githubusercontent.com/23093152/216810146-420fba90-4c5c-4a09-ae47-d32d012270b9.png">

# 2. Batch 를 이용하여 DB 의 Market 조회하는 Job
(Intellij 의 Build and Run 에서 Args 에 job 명시하여 실행)<br/>
<img width="716" alt="image" src="https://user-images.githubusercontent.com/23093152/216810180-d324f93b-a828-47b3-92f4-e5e86ca6f8c5.png">
<br/>(Batch 를 실행한 후 Job 의 실행과 DB 데이터 log 확인)<br/>
<img width="1469" alt="image" src="https://user-images.githubusercontent.com/23093152/216810210-537ea8b3-b8a2-4394-b67b-f9f0ace84db2.png">
<br/>(MySQL 에도 Batch 를 위한 메타데이터 테이블 생성 확인)<br/>
<img width="1463" alt="image" src="https://user-images.githubusercontent.com/23093152/216810276-adc4b9bf-3785-4dc6-b6ce-1f4ec1dea37a.png">
