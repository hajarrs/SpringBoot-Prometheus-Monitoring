# Monitoring Spring Boot Applications with Prometheus and Grafana

This README outlines the steps for setting up Prometheus and Grafana to monitor a Spring Boot application using Docker. By following these steps, you'll be able to pull Docker images from Docker Hub, run Prometheus and Grafana containers, and configure Grafana to use Prometheus as its data source.

## Setting Up Prometheus

### Step 1: Pull the Prometheus Docker Image

Start by pulling the latest Prometheus image from Docker Hub:

```bash```
docker pull prom/prometheus

### Step 2: Start the Prometheus Server

Run the Prometheus container, specifying the port and configuration file. Adjust the volume path to your prometheus.yml:

```bash```
docker run -p 9090:9090 -v $(pwd)/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
# Setting Up Grafana
## Run Grafana Container
Launch a Grafana container, mapping the necessary port:
```bash```
docker run -d --name=grafana -p 3000:3000 grafana/grafana
## Configuring Grafana to Use Prometheus
### Finding Prometheus IP Address
To allow Grafana to access Prometheus, find the IP address of your Prometheus container:
1. List all containers to find the Prometheus container:
```bash```
docker ps
2. Use docker inspect to get the IP address, replacing <container_id_or_name> with your container's actual ID or name:

```bash```
docker inspect <container_id_or_name> | grep IPAddress

### Access Grafana and Add Prometheus as a Data Source
1. Open Grafana by navigating to http://localhost:3000 in your web browser. The default login is admin for both the username and password.

2. Add Prometheus as a data source:

- Navigate to Configuration > Data Sources and click Add data source.
- Select Prometheus as the type.
- For the URL, use the Prometheus server's IP address found earlier, formatted as http://<IPAddress>:9090.
- Click Save & Test to confirm Grafana can connect to Prometheus.

# Conclusion
You have now successfully set up Prometheus to collect metrics from your Spring Boot application and configured Grafana to visualize these metrics. Begin exploring Grafana by creating dashboards and panels that provide insights into your application's performance and health.

Remember, specific configurations for Prometheus and Grafana may vary based on your application requirements and setup. Ensure you adjust paths, ports, and configurations as necessary.
