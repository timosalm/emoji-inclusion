```
NAMESPACE=default

helm repo add bitnami https://charts.bitnami.com/bitnami
helm install emoji bitnami/postgresql --set global.postgresql.auth.postgresPassword=password \
  --set global.postgresql.auth.database=emoji -n $NAMESPACE

kubectl create secret generic db-binding-compatible --from-literal=type=postgresql --from-literal=provider=bitnami \
 --from-literal=jdbc-url=jdbc:postgresql://emoji-postgresql.${NAMESPACE}.svc.cluster.local:5432/emoji \
 --from-literal=password=password --from-literal=username=postgres -n $NAMESPACE
 
 kubectl apply -f config/workload.yaml -n $NAMESPACE
```