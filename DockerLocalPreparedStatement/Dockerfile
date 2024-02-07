# MySQL resmi imajını kullan
FROM mysql

# Root şifresini ayarla
ENV MYSQL_ROOT_PASSWORD localdbpass

# init.sql dosyasını container içinde /docker-entrypoint-initdb.d/ dizinine kopyala
# Bu dizindeki SQL dosyaları otomatik olarak çalıştırılır
COPY init.sql /docker-entrypoint-initdb.d/

