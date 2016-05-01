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
package org.scribble.tools.che.server.projecttype;

import com.google.inject.Inject;

import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.scribble.tools.che.shared.ProjectAttributes;

/**
 * Scribble  project type.
 *
 */
public class ScribbleProjectType extends ProjectTypeDef {
    @Inject
    public ScribbleProjectType() {
        super(ProjectAttributes.SCRIBBLE_ID, ProjectAttributes.SCRIBBLE_NAME, true, false, true);
        addConstantDefinition(ProjectAttributes.LANGUAGE, ProjectAttributes.LANGUAGE, ProjectAttributes.SCRIBBLE_ID);
    }

}
