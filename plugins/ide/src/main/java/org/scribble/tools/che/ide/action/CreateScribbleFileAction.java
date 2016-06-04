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
package org.scribble.tools.che.ide.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.api.workspace.shared.dto.ProjectConfigDto;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.app.CurrentProject;
import org.eclipse.che.ide.newresource.AbstractNewResourceAction;
import org.scribble.tools.che.ide.ScribbleLocalizationConstant;
import org.scribble.tools.che.ide.ScribbleResources;

import javax.validation.constraints.NotNull;

import static org.scribble.tools.che.shared.ProjectAttributes.SCRIBBLE_EXT;
import static org.scribble.tools.che.shared.ProjectAttributes.SCRIBBLE_ID;

/**
 * Action to create new Scribble source file.
 *
 */
@Singleton
public class CreateScribbleFileAction extends AbstractNewResourceAction {
    private final AppContext appContext;

    @Inject
    public CreateScribbleFileAction(ScribbleLocalizationConstant localizationConstant,
                                  ScribbleResources scribbleResources,
                                  AppContext appContext) {
        super(localizationConstant.createScribbleFileActionTitle(),
              localizationConstant.createScribbleFileActionDescription(),
              scribbleResources.scribbleFile());
        this.appContext = appContext;
    }

    @Override
    public void updateInPerspective(@NotNull ActionEvent event) {
        CurrentProject currentProject = appContext.getCurrentProject();
        if (currentProject == null) {
            return;
        }
        ProjectConfigDto projectConfig = currentProject.getProjectConfig();
        String type = projectConfig.getType();
        event.getPresentation().setEnabledAndVisible(SCRIBBLE_ID.equals(type));
    }

    @Override
    protected String getExtension() {
        return SCRIBBLE_EXT;
    }

    @Override
    protected String getDefaultContent() {
        return "";
    }

}
