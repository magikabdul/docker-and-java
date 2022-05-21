import com.github.dockerjava.api.DockerClient;
import docker.DockerInstance;
import lombok.extern.slf4j.Slf4j;
import service.DockerService;

@Slf4j
public class Application {
    private static String LOG_PATTERN = "DOCKER method: %s test";

    public static void main(String[] args) {
        log.info("Application start");
        DockerService dockerService = new DockerService();

        logCommand("pingCmd");
        dockerService.ping();

        logCommand("pullImage");
        dockerService.pullImage();
    }

    private static void logCommand(String command) {
        log.info(String.format(LOG_PATTERN, "\"" + command + "\""));
    }
}
