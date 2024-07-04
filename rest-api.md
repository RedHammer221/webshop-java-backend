- Pfad
- Query Parameter
- Http Verb: GET, POST, PUT, DELETE (Head, OPTIONS, PATCH, TRACE)
- Request Body

REST: Ressourcen
Produkte
Kunden
Bestellungen

Lade alle Produkte vom Server:
GET /api/products

Lade Produkt mit bestimmter ID
GET /api/products/{id}

Update Produktbeschreibung
PUT /api/products/{id}/description

Update Produkt
PUT /api/products/{id}

Lade Produkte mit bestimmtem Tag
GET /api/products?tag={tag}

Erzeuge neues Produkt
POST /api/createProduct

Loesche Produkt
DELETE /api/products/{id}

Bestelle Produkt == Erzeuge neue Bestellung
POST /api/orders

Fuege Produkt zur Bestellung hinzu
PUT /api/orders/{id}/products

Fuege Tags zu Produkt hinzu
PUT /api/products/{id}/tags

Aendere Preis eines Produkts
PUT /api/updatePrice/{id}/price