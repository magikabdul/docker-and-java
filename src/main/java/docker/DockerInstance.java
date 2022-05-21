package docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;

public class DockerInstance {

    private DockerClientConfig getDockerClientConfig() {
        return DefaultDockerClientConfig.createDefaultConfigBuilder()
//                .withDockerHost("tcp://localhost:2375")
                .withDockerHost("unix:///var/run/docker.sock")
                .build();
    }

    private DockerHttpClient getHttpClient() {
        return new ApacheDockerHttpClient.Builder()
                .dockerHost(getDockerClientConfig().getDockerHost())
                .build();
    }

    public DockerClient getClient() {
        return DockerClientImpl.getInstance(getDockerClientConfig(), getHttpClient());
    }
}
