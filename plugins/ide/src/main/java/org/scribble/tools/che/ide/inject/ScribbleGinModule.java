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
package org.scribble.tools.che.ide.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.scribble.tools.che.ide.ScribbleResources;
import org.scribble.tools.che.ide.project.ScribbleProjectWizardRegistrar;

import static org.scribble.tools.che.shared.ProjectAttributes.SCRIBBLE_EXT;

/**
 * @author Valeriy Svydenko
 */
@ExtensionGinModule
public class ScribbleGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        GinMultibinder.newSetBinder(binder(), ProjectWizardRegistrar.class).addBinding().to(ScribbleProjectWizardRegistrar.class);
    }

    @Provides
    @Singleton
    @Named("ScribbleFileType")
    protected FileType provideScribbleFile() {
        return new FileType(ScribbleResources.INSTANCE.scribbleFile(), SCRIBBLE_EXT);
    }

}
