package org.lordofthejars.shading;

import com.google.common.collect.ImmutableSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
        "red",
        "orange",
        "yellow",
        "green",
        "blue",
        "purple");

    public static void main( String[] args )
    {
        System.out.println(COLOR_NAMES);
    }
}
