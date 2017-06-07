# API文档

## 登录
URL | HTTPMethod | 功能
---|--- | ---
/ | GET | 前往登录页面
gotoLogin | GET | 前往登录页面
login | POST | 提交表单进行用户登录，若成功前往用户详情页面，否则返回登录页面


## 注册
URL | HTTPMethod | 功能
---|--- | ---
gotoLRegister | GET | 前往注册页面
register | POST | 提交表单进行用户注册，若成功前往用户详情页面，否则返回登录页面

## 用户详情
URL | HTTPMethod | 功能
---|--- | ---
update | POST  |提交表单进行用户更新，若成功前往用户详情页面，否则返回登录页面
backToInfo | GET | 返回用户详情页面，若成功前往用户详情页面，否则返回登录页面

## 查询用户预订
URL | HTTPMethod | 功能
---|--- | ---
reservation | GET | 查询用户订单，若成功前往用户订单页面，否则返回登录页面

## 修改用户预订
URL | HTTPMethod | 功能
---|--- | ---
MovieItem/{id} | DELETE | 删除用户订单中的id电影场次，若成功返回用户订单页面，否则返回登录页面
/MovieItem/{id} | PUT |  向用户订单中添加id电影场次，若成功返回选票页面，否则返回登录页面

## 查询影院
URL | HTTPMethod | 功能
---|--- | ---
queryCinema | GET | 查询所有的影院

## 查询电影
URL | HTTPMethod | 功能
---|--- | ---
queryCinema | GET | 查询所有的电影

## 查询电影场次
URL | HTTPMethod | 功能
---|--- | ---
queryMovieItemsByCinema?id={id} | GET | 查询id电影院放映的电影场次，返回电影场次
queryMovieItemsByMovie？id={id} | GET | 查询id电影上映的电影场次，返回电影场次
