#### Common: list Restaurants
`curl -s http://localhost:18080/restvoting/rest/restaurants/list --user admin@gmail.com:admin`

#### Admin: add new Restaurant
`curl -s -X POST -d '{"name":"Added Restaurant 1"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:18080/restvoting/rest/admin/restaurants/add --user admin@gmail.com:admin`

#### Admin: add many dishes to restaurant's menu for some date
`curl -s -X POST -d '[{"dateTime":"2018-12-15T09:00","description":"Steak","price":100.00}, {"dateTime":"2018-12-15T09:00", 
"description":"Soup 2","price":155.00}]' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:18080/restvoting/rest/admin/dishes/add/many/100014 --user admin@gmail.com:admin`

#### User: list dishes by restaurantId
`curl -s http://localhost:18080/restvoting/rest/dishes/100003 --user user@yandex.ru:password`

#### User: vote for Restaurant by restaurantId
`curl -s -X POST http://localhost:18080/restvoting/rest/votes/100002 --user user@yandex.ru:password`

#### User: get votes for date
`curl -s http://localhost:18080/restvoting/rest/votes/2019-01-18 --user user@yandex.ru:password`