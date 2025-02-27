FROM mcr.microsoft.com/dotnet/aspnet:5.0 AS base
WORKDIR /app
EXPOSE 80

FROM mcr.microsoft.com/dotnet/sdk:5.0 AS build
WORKDIR /src
COPY ["src/csharp-api.csproj", "./"]
RUN dotnet restore "./csharp-api.csproj"
COPY . .
WORKDIR "/src/src"
RUN dotnet build "csharp-api.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "csharp-api.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "csharp-api.dll"]

