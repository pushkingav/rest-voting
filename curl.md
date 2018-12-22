
#### Admin: add Dishes
`curl -s -X POST -d '[{"dateTime":"2018-12-15T09:00","description":"Солянка","price":150.70, "restaurant_id": 100002}, 
{"dateTime":"2018-12-15T09:00","description":"Котлета","price":100.00, "restaurant_id": 100002}]' -H 'Content-Type:application/json; 
charset=UTF-8' http://localhost:18080/restvoting/rest/admin/add`