oc new-app -e POSTGRESQL_USER=quarkus-user -e POSTGRESQL_PASSWORD=quarkus-pwd -e POSTGRESQL_DATABASE=developer-db centos/postgresql-95-centos7
oc expose svc/postgresql-95-centos7