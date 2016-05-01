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
package org.scribble.tools.che.ide;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.constraints.Constraints;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import org.eclipse.che.ide.api.icon.Icon;
import org.eclipse.che.ide.api.icon.IconRegistry;
import org.scribble.tools.che.ide.action.CreateScribbleFileAction;

import static org.eclipse.che.ide.api.action.IdeActions.GROUP_FILE_NEW;
import static org.scribble.tools.che.shared.ProjectAttributes.SCRIBBLE_CATEGORY;;

/**
 * Scribble extension entry point.
 *
 */
@Extension(title = "Scribble")
public class ScribbleExtension {
    @Inject
    public ScribbleExtension(FileTypeRegistry fileTypeRegistry,
                           CreateScribbleFileAction createScribbleFileAction,
                           ActionManager actionManager,
                           ScribbleResources scribbleResources,
                           IconRegistry iconRegistry,
                           @Named("ScribbleFileType") FileType scribbleFile) {
        fileTypeRegistry.registerFileType(scribbleFile);

        DefaultActionGroup newGroup = (DefaultActionGroup)actionManager.getAction(GROUP_FILE_NEW);
        actionManager.registerAction("scribbleFile", createScribbleFileAction);
        newGroup.add(createScribbleFileAction, Constraints.FIRST);

        iconRegistry.registerIcon(new Icon(SCRIBBLE_CATEGORY + ".samples.category.icon", scribbleResources.category()));
    }

}
