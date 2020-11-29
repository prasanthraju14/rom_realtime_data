# rom_realtime_data
Real time data Processing

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
