/**
 * Copyright 2012 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.inject;

import org.droidparts.activity.FragmentActivity;
import org.droidparts.inject.injector.FragmentsInjectorDelegate;
import org.droidparts.inject.injector.InjectorDelegate;

import android.support.v4.app.Fragment;

public class FragmentsInjector extends Injector {

	public static FragmentsInjector get() {
		if (injector == null) {
			synchronized (Injector.class) {
				if (injector == null) {
					injector = new FragmentsInjector(
							new FragmentsInjectorDelegate());
				}
			}
		}
		return injector;
	}

	private static FragmentsInjector injector;

	public void inject(Fragment fragment) {
		inject(fragment.getView(), fragment);
	}

	public void inject(FragmentActivity activity) {
		super.inject(activity);
	}

	protected FragmentsInjector(InjectorDelegate delegate) {
		super(delegate);
	}

}
