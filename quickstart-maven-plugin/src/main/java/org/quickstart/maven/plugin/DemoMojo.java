package org.quickstart.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author buhao
 * @version DemoMojo.java, v 0.1 2020-03-30 22:51 buhao
 */
@Mojo(name = "hello")
public class DemoMojo extends AbstractMojo {

    @Parameter(name = "name", defaultValue = "kiwi")
    private String name;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("hello " + name);
    }

}
