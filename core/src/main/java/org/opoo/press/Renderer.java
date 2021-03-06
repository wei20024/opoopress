/*
 * Copyright 2013 Alex Lin.
 *
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
 */
package org.opoo.press;

import java.io.Writer;
import java.util.Map;

import org.opoo.press.source.SourceEntry;

/**
 * @author Alex Lin
 *
 */
public interface Renderer {
	
	String render(String templateName, Map<String, Object> rootMap);

	void render(String templateName, Map<String, Object> rootMap, Writer out);

	String renderContent(String templateContent, Map<String, Object> rootMap);

	void renderContent(String templateContent, Map<String, Object> rootMap,	Writer out);

	String prepareWorkingTemplate(String layout, boolean isValidLayout,
			String content, boolean isContentRenderRequired, SourceEntry entry);
	
	void prepareLayoutWorkingTemplates();
	
	String getLayoutWorkingTemplate(String layout);

	boolean isRenderRequired(String content);

	boolean isValidLayout(String layout);
}
