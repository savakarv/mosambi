package com.mosambi.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by vishwanath.s on 10/02/15.
 */
public class Saying
{
    private long id;

    @Length(max = 3)
    private String content;

    public Saying()
    {

    }

    public Saying(long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId()
    {
        return this.id;
    }

    @JsonProperty
    public String getContent()
    {
        return this.content;
    }
}
