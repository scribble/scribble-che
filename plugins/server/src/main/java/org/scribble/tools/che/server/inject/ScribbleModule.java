/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scribble.tools.che.server.inject;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import org.eclipse.che.api.project.server.handlers.ProjectHandler;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.eclipse.che.inject.DynaModule;
import org.scribble.tools.che.server.generator.ScribbleProjectGenerator;
import org.scribble.tools.che.server.projecttype.ScribbleProjectType;

import static com.google.inject.multibindings.Multibinder.newSetBinder;

/**
 */
@DynaModule
public class ScribbleModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<ProjectTypeDef> projectTypeMultibinder = newSetBinder(binder(), ProjectTypeDef.class);
        projectTypeMultibinder.addBinding().to(ScribbleProjectType.class);

        Multibinder<ProjectHandler> projectHandlerMultibinder = newSetBinder(binder(), ProjectHandler.class);
        projectHandlerMultibinder.addBinding().to(ScribbleProjectGenerator.class);
    }
}
