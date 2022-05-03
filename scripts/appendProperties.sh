echo "vaadin.productionMode=true" >> src/main/resources/application.properties

#we do this in Application.java manually at runtime
#echo "server.ssl.enabled=true" >> src/main/resources/application.properties
#echo "server.ssl.key-store-password="$(cat /run/secrets/certpass.txt)"" >> src/main/resources/application.properties
