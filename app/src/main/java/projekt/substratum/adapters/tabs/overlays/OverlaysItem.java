/*
 * Copyright (c) 2016-2017 Projekt Substratum
 * This file is part of Substratum.
 *
 * Substratum is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Substratum is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Substratum.  If not, see <http://www.gnu.org/licenses/>.
 */

package projekt.substratum.adapters.tabs.overlays;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.SpinnerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import projekt.substratum.common.Packages;
import projekt.substratum.common.Systems;

import static projekt.substratum.common.Packages.isPackageInstalled;
import static projekt.substratum.common.Resources.SETTINGS;
import static projekt.substratum.common.Resources.SETTINGS_ICONS;
import static projekt.substratum.common.Resources.SYSTEMUI;
import static projekt.substratum.common.Resources.SYSTEMUI_HEADERS;
import static projekt.substratum.common.Resources.SYSTEMUI_NAVBARS;
import static projekt.substratum.common.Resources.SYSTEMUI_QSTILES;
import static projekt.substratum.common.Resources.SYSTEMUI_STATUSBARS;

public class OverlaysItem implements Serializable {

    public String versionName;
    public String attention;
    public boolean isVariantChosen;
    public boolean isVariantChosen1;
    public boolean isVariantChosen2;
    public boolean isVariantChosen3;
    public boolean isVariantChosen4;
    public boolean isVariantChosen5;
    public boolean variantMode;
    private String themeName;
    private String packageName;
    private VariantAdapter array;
    private VariantAdapter array2;
    private VariantAdapter array3;
    private VariantAdapter array4;
    private VariantAdapter array5;
    private Context context;
    private Drawable appIcon;
    private boolean themeOms;
    private View activityView;
    private String name;
    private String targetVersion;
    private boolean isSelected;
    private boolean isVariantInstalled;
    private int spinnerSelection;
    private int spinnerSelection2;
    private int spinnerSelection3;
    private int spinnerSelection4;
    private int spinnerSelection5;
    private String variantSelected = "";
    private String variantSelected2 = "";
    private String variantSelected3 = "";
    private String variantSelected4 = "";
    private String variantSelected5 = "";
    private String baseResources = "";
    private List<Object> enabledOverlays;

    public OverlaysItem(String themeName,
                        String name,
                        String packageName,
                        boolean isSelected,
                        VariantAdapter adapter,
                        VariantAdapter adapter2,
                        VariantAdapter adapter3,
                        VariantAdapter adapter4,
                        VariantAdapter adapter5,
                        Context context,
                        String versionName,
                        String baseResources,
                        Collection enabledOverlays,
                        boolean themeOms,
                        String attention,
                        View activityView) {
        super();
        this.themeName = themeName;
        this.name = name;
        this.packageName = packageName;
        this.isSelected = isSelected;
        this.array = adapter;
        this.array2 = adapter2;
        this.array3 = adapter3;
        this.array4 = adapter4;
        this.array5 = adapter5;
        this.context = context;
        this.versionName = versionName;
        this.themeOms = themeOms;
        if (this.baseResources != null)
            this.baseResources =
                    baseResources.replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9]+", "");
        this.variantMode = true;
        this.enabledOverlays = new ArrayList<>();
        this.enabledOverlays.addAll(enabledOverlays);
        this.appIcon = Packages.getAppIcon(context, packageName);
        this.attention = attention;
        this.activityView = activityView;
        this.isVariantInstalled = isPackageInstalled(context,
                this.getPackageName() + '.' + this.getThemeName() +
                        ((!this.getBaseResources().isEmpty()) ?
                                '.' + this.getBaseResources() : ""));
    }

    View getActivityView() {
        return activityView;
    }

    boolean isDeviceOMS() {
        return themeOms;
    }

    public String getThemeName() {
        return themeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Drawable getAppIcon() {
        return appIcon;
    }

    public String getPackageName() {
        return packageName;
    }

    String getBaseResources() {
        return baseResources;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public SpinnerAdapter getSpinnerArray() {
        return array;
    }

    public SpinnerAdapter getSpinnerArray2() {
        return array2;
    }

    public SpinnerAdapter getSpinnerArray3() {
        return array3;
    }

    public SpinnerAdapter getSpinnerArray4() {
        return array4;
    }

    public SpinnerAdapter getSpinnerArray5() {
        return array5;
    }

    int getSelectedVariant() {
        return spinnerSelection;
    }

    void setSelectedVariant(int position) {
        if (position != 0) {
            isVariantChosen = true;
            isVariantChosen1 = true;
        } else {
            isVariantChosen = false;
            isVariantChosen1 = false;
        }
        spinnerSelection = position;
    }

    public void updateEnabledOverlays(Collection<String> enabledOverlays) {
        this.enabledOverlays = new ArrayList<>();
        this.enabledOverlays.addAll(enabledOverlays);
    }

    int getSelectedVariant2() {
        return spinnerSelection2;
    }

    void setSelectedVariant2(int position) {
        if (position != 0) {
            isVariantChosen = true;
            isVariantChosen2 = true;
        } else {
            isVariantChosen = false;
            isVariantChosen2 = false;
        }
        spinnerSelection2 = position;
    }

    int getSelectedVariant3() {
        return spinnerSelection3;
    }

    void setSelectedVariant3(int position) {
        if (position != 0) {
            isVariantChosen = true;
            isVariantChosen3 = true;
        } else {
            isVariantChosen = false;
            isVariantChosen3 = false;
        }
        spinnerSelection3 = position;
    }

    int getSelectedVariant4() {
        return spinnerSelection4;
    }

    void setSelectedVariant4(int position) {
        if (position != 0) {
            isVariantChosen = true;
            isVariantChosen4 = true;
        } else {
            isVariantChosen = false;
            isVariantChosen4 = false;
        }
        spinnerSelection4 = position;
    }

    int getSelectedVariant5() {
        return spinnerSelection5;
    }

    void setSelectedVariant5(int position) {
        if (position != 0) {
            isVariantChosen = true;
            isVariantChosen5 = true;
        } else {
            isVariantChosen = false;
            isVariantChosen5 = false;
        }
        spinnerSelection5 = position;
    }

    public String getSelectedVariantName() {
        return variantSelected.replaceAll("\\s+", "");
    }

    void setSelectedVariantName(String variantName) {
        variantSelected = variantName;
    }

    public String getSelectedVariantName2() {
        return variantSelected2.replaceAll("\\s+", "");
    }

    void setSelectedVariantName2(String variantName) {
        variantSelected2 = variantName;
    }

    public String getSelectedVariantName3() {
        return variantSelected3.replaceAll("\\s+", "");
    }

    void setSelectedVariantName3(String variantName) {
        variantSelected3 = variantName;
    }

    public String getSelectedVariantName4() {
        return variantSelected4.replaceAll("\\s+", "");
    }

    void setSelectedVariantName4(String variantName) {
        variantSelected4 = variantName;
    }

    public String getSelectedVariantName5() {
        return variantSelected5.replaceAll("\\s+", "");
    }

    void setSelectedVariantName5(String variantName) {
        variantSelected5 = variantName;
    }

    Context getContext() {
        return context;
    }

    boolean compareInstalledOverlay() {
        try {
            PackageInfo pinfo =
                    context.getPackageManager().getPackageInfo(getFullOverlayParameters(), 0);
            return !pinfo.versionName.equals(versionName);
        } catch (Exception ignored) {
        }
        return true;
    }

    boolean compareInstalledVariantOverlay(String varianted) {
        String variant = varianted;
        if (!".".equals(variant.substring(0, 1))) variant = '.' + variant;
        String base = baseResources;
        if (!baseResources.isEmpty() && !".".equals(baseResources.substring(0, 1))) {
            base = '.' + base;
        }
        try {
            PackageInfo packageInfo =
                    context.getPackageManager().getPackageInfo(
                            packageName + '.' + themeName + variant + base, 0);
            return packageInfo.versionName.equals(versionName);
        } catch (Exception ignored) {
        }
        return false;
    }

    public String getFullOverlayParameters() {
        return packageName + '.' + themeName +
                (((spinnerSelection == 0 &&
                        spinnerSelection2 == 0 &&
                        spinnerSelection3 == 0 &&
                        spinnerSelection4 == 0) &&
                        spinnerSelection5 == 0) ? "" : ".") +
                (((spinnerSelection == 0) ? "" : getSelectedVariantName()) +
                        ((spinnerSelection2 == 0) ? "" : getSelectedVariantName2()) +
                        ((spinnerSelection3 == 0) ? "" : getSelectedVariantName3()) +
                        ((spinnerSelection4 == 0) ? "" : getSelectedVariantName4()) +
                        ((spinnerSelection5 == 0) ? "" : getSelectedVariantName5()))
                        .replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]+", "") +
                ((baseResources.isEmpty()) ? "" : '.' + baseResources);
    }

    public boolean isOverlayEnabled() {
        boolean installed = Packages.isPackageInstalled(context, getFullOverlayParameters());
        if (Systems.isSamsungDevice(context)) {
            return installed;
        } else {
            return installed && (enabledOverlays.contains(getFullOverlayParameters()));
        }
    }

    public boolean isVariantInstalled() {
        return isVariantInstalled;
    }

    public String getTargetVersion() {
        if (targetVersion == null) {
            setTargetVersion();
        }
        return targetVersion;
    }

    private void setTargetVersion() {
        String targetVersion;
        switch (getPackageName()) {
            case SYSTEMUI_HEADERS:
            case SYSTEMUI_NAVBARS:
            case SYSTEMUI_STATUSBARS:
            case SYSTEMUI_QSTILES:
                targetVersion = Packages.getAppVersion(context, SYSTEMUI);
                break;
            case SETTINGS_ICONS:
                targetVersion = Packages.getAppVersion(context, SETTINGS);
                break;
            default:
                targetVersion = Packages.getAppVersion(context, getPackageName());
        }
        this.targetVersion = targetVersion;
    }
}