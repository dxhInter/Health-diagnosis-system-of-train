# Health diagnosis of train

Programming language: JavaFX\
Project time: July06 2021

# 面向重载货运机车健康诊断的数据采集及可视化方法的设计及实现


![WechatIMG126](https://user-images.githubusercontent.com/49583225/121217810-c766be80-c8b4-11eb-8ce6-ac9a52b20322.jpeg)  

### Introduction

基于JavaFX、ECharts 和 MySQL实现了机车运行数据监测及诊断软件，具有数据接收功能、数据显示功能、机车健康诊断、数据库分表等核心模块。采用数据表循环存储的分表策略存储数据；使用udp与车辆传感器进行通讯来获取数据；通过echarts来显示车辆实时数据。

The locomotive operation data monitoring and diagnosis software is implemented based on JavaFX, ECharts and MySQL, with core modules such as data receiving function, data display function, locomotive health diagnosis and database splitting table. The data is stored using the table splitting strategy of cyclic storage of data tables; udp is used to communicate with vehicle sensors to obtain data; echarts are used to display real-time vehicle data.


### 2021年5月11号

1.更新数据库的定期备份，以及恢复数据的功能。  
2.添加第五个节点的第一个传感器数值利用，开发Echart历史数据与实时显示。  
3.数据库分库，读写分离  
4.echart的显示节点（异常点突出显示，添加标志位）「1、实时显示，2、历史数据查看」。  
