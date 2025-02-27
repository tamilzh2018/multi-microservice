FROM golang:1.15

WORKDIR /app

# Copy go.mod and go.sum files first
COPY go.mod go.sum ./

# Download dependencies
RUN go mod download

# Copy the source files
COPY ./src ./src

# Set the working directory to the source folder
WORKDIR /app/src

# Build the Go application
RUN go build -o main .

CMD ["./main"]

