项目开始阶段，数据库表格的数据是手工录入的，数据量不大。主要包括以下表格，这些表格在spring架构中有对应的类来读取相关的数据：

- movie表：条目为(id, name, type, stars)，分别表示电影的id、电影名、电影所属类型、电影星级
- cinema表：条目为(id, name, address, stars, info, max_discount, town)，分别表示电影院的id，名字、地址、星级、关于影院的额外信息、影院折扣
- movieItem表：条目为(id, movie, cinema, seat, price, duration)，分别表示电影场次的id、电影在movie表中的id、在cinema表中的id、票价、作为总数、电影时长
- city表：条目为(id, name, province)，分别表示城市的id、名字、所在省份的id
- province表：条目为(id, name)，分别表示省份的id、名字
- town表：条目为(id, name, city)，分别表示县的id、名字、所在城市的id