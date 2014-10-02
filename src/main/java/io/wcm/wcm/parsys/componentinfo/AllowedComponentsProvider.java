/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.wcm.parsys.componentinfo;

import java.util.Set;

import org.apache.sling.api.resource.ResourceResolver;

/**
 * Detects allowed components for authoring for a given page/resource context.
 */
public interface AllowedComponentsProvider {

  /**
   * Get allowed components for a specific resource path inside a page.
   * @param resourcePath Resource path inside a page
   * @param resolver Resource resolver
   * @return Component paths
   */
  Set<String> getAllowedComponents(String resourcePath, ResourceResolver resolver);

  /**
   * Get allowed components anywhere inside a page.
   * @param pageComponentPath Page component path of page
   * @param resolver Resource resolver
   * @return Component paths
   */
  Set<String> getAllowedComponentsForTemplate(String pageComponentPath, ResourceResolver resolver);

}
