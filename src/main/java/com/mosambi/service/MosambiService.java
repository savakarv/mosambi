package com.mosambi.service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.mosambi.config.MosambiServiceConfiguration;
import com.mosambi.res.MosambiResource;

/**
 * Created by vishwanath.s on 10/02/15.
 */
public class MosambiService extends Service<MosambiServiceConfiguration>
{
    private String name = "mosambi-configuration";

    public static void main(String[] args) throws Exception
    {
        new MosambiService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MosambiServiceConfiguration> bootstrap)
    {
        bootstrap.setName(name);
    }

    @Override
    public void run(MosambiServiceConfiguration mosambiServiceConfiguration, Environment environment) throws Exception
    {
        final MosambiResource resource = new MosambiResource(
                mosambiServiceConfiguration.getTemplate(),
                mosambiServiceConfiguration.getDefaultName()
        );

        environment.addResource(resource);
    }
}
