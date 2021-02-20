FROM java
ADD ./target/order_mgmt-0.0.1-SNAPSHOT.jar /order_mgmt-0.0.1-SNAPSHOT.jar
ADD ./run.sh /run.sh
RUN chmod a+x /run.sh
CMD /run.sh
