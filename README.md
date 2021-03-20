# rom_realtime_data 

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
