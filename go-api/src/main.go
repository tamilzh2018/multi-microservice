// main.go
package main

import (
    "encoding/json"
    "net/http"
    "github.com/gorilla/mux"
)

type Message struct {
    Message string `json:"message"`
}

func getData(w http.ResponseWriter, r *http.Request) {
    response := Message{Message: "Hello from Go!"}
    json.NewEncoder(w).Encode(response)
}

func main() {
    r := mux.NewRouter()
    r.HandleFunc("/api/data", getData).Methods("GET")
    http.ListenAndServe(":8000", r)
}
