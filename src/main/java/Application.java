import com.github.dockerjava.api.DockerClient;
import docker.DockerInstance;
import service.DockerService;

public class Application {

    public static void main(String[] args) {
//        DockerClient dockerClient = new DockerInstance().getClient();
//
//        dockerClient.pingCmd().exec();
        new DockerService().start();
    }
}
