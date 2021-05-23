let app = require("express")();
app.get("/", (req, res) => {
	res.end("Hello there!");
});

app.listen(7000);
console.log("Server running in 7000");