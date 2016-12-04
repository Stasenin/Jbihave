package com.jbhvtest.steps;
// ЗАПУСКАТЬ МОЖНО ИЛИ ЧЕРЕЗ Story Configuratior или через аннотацию JUnit в классе AnnotatedTraderEmbedder.

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.List;


import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;



    @RunWith(AnnotatedEmbedderRunner.class)
    @Configure(storyControls = AnnotatedTraderEmbedder.MyStoryControls.class, storyLoader = AnnotatedTraderEmbedder.MyStoryLoader.class, storyReporterBuilder = AnnotatedTraderEmbedder.MyReportBuilder.class,
            parameterConverters = { AnnotatedTraderEmbedder.MyDateConverter.class })
    @UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true, verboseFailures = true,
            storyTimeoutInSecs = 100, threads = 2, metaFilters = "-skip")
    @UsingSteps(instances = { JbhvSteps.class, StoryConfigurator.class })

    public class AnnotatedTraderEmbedder extends InjectableEmbedder {

        @Test
        public void run() {
            List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
            injectedEmbedder().runStoriesAsPaths(storyPaths);
        }

        public static class MyStoryControls extends StoryControls {
            public MyStoryControls() {
                doDryRun(false);
                doSkipScenariosAfterFailure(false);
            }
        }

        public static class MyStoryLoader extends LoadFromClasspath {
            public MyStoryLoader() {
                super(AnnotatedTraderEmbedder.class.getClassLoader());
            }
        }

        public static class MyReportBuilder extends StoryReporterBuilder {
            public MyReportBuilder() {
                this.withFormats(CONSOLE, TXT, HTML, XML).withDefaultFormats();
            }
        }

        public static class MyRegexPrefixCapturingPatternParser extends RegexPrefixCapturingPatternParser {
            public MyRegexPrefixCapturingPatternParser() {
                super("%");
            }
        }

        public static class MyDateConverter extends ParameterConverters.DateConverter {
            public MyDateConverter() {
                super(new SimpleDateFormat("yyyy-MM-dd"));
            }
        }

    }



