
echo "Simulating whatever your IT guys could do to provide your postgresql database"
echo "..."
oc new-app \
    -e POSTGRESQL_USER=test \
    -e POSTGRESQL_PASSWORD=test \
    -e POSTGRESQL_DATABASE=developer \
    --name=developer-database \
    openshift/postgresql

echo ""
echo "your IT folks say your user/password is test/test the database is called developer "
echo "and the host:port to access the database is developer-database:5432"