# rom_realtime_data 

(Work in progress)
==================

Swagger Details:
===============
http://localhost:8080/swagger-ui.html#

createOrder sample JSON:
=======================
{
    "id": 111111,
    "createdAt": "2020-12-01T17:30:31.010+00:00",
    "orderItemList": [
        {
            "orderItemId": 31,
            "productId": 1011111,
            "qty": 11111,
            "fromLocation": "Hyd",
            "toLocation": "Blr",
            "uom": "kg",
            "uomType": "KG"
        },
        {
            "orderItemId": 78,
            "productId": 105552,
            "qty": 22,
            "fromLocation": "Delhi",
            "toLocation": "Kashmir",
            "uom": "Piece",
            "uomType": "No"
        },
        {
            "orderItemId": 8888,
            "productId": 104444,
            "qty": 9,
            "fromLocation": "Mumbak",
            "toLocation": "Vizag",
            "uom": "Dozen",
            "uomType": "DZ"
        }
    ]
}

Real time data Processing
=========================
Retail order management application (ROM) is generating couple of millions orders per day. Sample Order format for an order is given below:

Sample Input
{
  "orderId": 11111,
  "products": [
    {
      "product_id": "1234",
      "order_qty": 2,
      "from_location": "1",
      "to_location": 2,
      "unit_of_measures": 3,
      "uom_type": "E"
    },
    {
      "product_id": "1234",
      "order_qty": 2,
      "from_location": "1",
      "to_location": 2,
      "unit_of_measures": 3,
      "uom_type": "E"
    }
  ]
}

Build ROM application which is generating random order in above format. Number of orders created should not be less than 1000. 

ROM application should be able to scale for millions of orders. Also provide a user interface which can show these generated orders in almost real time (within 1 minute of order creation. Also provide search functionality so that orders can be searched. 

Sample output
Order Id	ProductId	Quantity	UOM
123456	1234	2	E
234566	3214	3	Kg


ROM and consuming application should be developed for high performance and scalability however input data can be limited to few thousands. Solution will be evaluated for provisions for performance and scalability. 
