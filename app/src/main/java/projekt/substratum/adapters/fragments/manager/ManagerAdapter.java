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

package projekt.substratum.adapters.fragments.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import projekt.substratum.R;
import projekt.substratum.common.Packages;
import projekt.substratum.common.References;

import static android.text.Html.FROM_HTML_MODE_LEGACY;

public class ManagerAdapter extends
        RecyclerView.Adapter<ManagerAdapter.ViewHolder> {

    private List<ManagerItem> overlayList;
    private final Boolean floatui;

    public ManagerAdapter(final List<ManagerItem> overlays, final Boolean floatui) {
        super();
        this.floatui = floatui;
        this.overlayList = overlays;
    }

    @Override
    public ManagerAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View itemLayoutView;
        if (this.floatui) {
            itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.floatui_row, parent, false);
        } else {
            itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.manager_row, parent, false);
        }
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final int position_fixed = position;
        final Context context = this.overlayList.get(position_fixed).getContext();
        final String packageName = this.overlayList.get(position_fixed).getName();

        final String title = this.overlayList.get(position_fixed).getLabelName();

        if (title != null && !title.isEmpty()) {
            viewHolder.tvName.setText(title);
        } else {
            viewHolder.tvName.setText(R.string.reboot_awaiting_manager_title);
        }

        viewHolder.tvName.setTextColor(this.overlayList.get(position_fixed).getActivationValue());

        if (this.overlayList.get(position_fixed).getType1a() == null) {
            String metadata = Packages.getOverlayMetadata(
                    context,
                    packageName,
                    References.metadataOverlayType1a);

            if (metadata != null && !metadata.isEmpty()) {
                metadata = metadata.replace("_", " ");
                final String textView = "<b>" + context.getString(R.string.manager_type1a) +
                        "</b> " + metadata;
                viewHolder.type1a.setVisibility(View.VISIBLE);
                this.overlayList.get(position_fixed).setType1a(textView);
                viewHolder.type1a.setText(Html.fromHtml(textView, FROM_HTML_MODE_LEGACY));
            } else {
                viewHolder.type1a.setVisibility(View.GONE);
            }
        } else {
            viewHolder.type1a.setVisibility(View.VISIBLE);
            viewHolder.type1a.setText(Html.fromHtml(this.overlayList.get(position_fixed).getType1a(),
                    FROM_HTML_MODE_LEGACY));
        }

        if (this.overlayList.get(position_fixed).getType1b() == null) {
            String metadata = Packages.getOverlayMetadata(
                    context,
                    packageName,
                    References.metadataOverlayType1b);
            if (metadata != null && !metadata.isEmpty()) {
                metadata = metadata.replace("_", " ");
                final String textView = "<b>" + context.getString(R.string.manager_type1b) +
                        "</b> " + metadata;
                viewHolder.type1b.setVisibility(View.VISIBLE);
                this.overlayList.get(position_fixed).setType1b(textView);
                viewHolder.type1b.setText(Html.fromHtml(textView, FROM_HTML_MODE_LEGACY));
            } else {
                viewHolder.type1b.setVisibility(View.GONE);
            }
        } else {
            viewHolder.type1b.setVisibility(View.VISIBLE);
            viewHolder.type1b.setText(Html.fromHtml(this.overlayList.get(position_fixed).getType1b(),
                    FROM_HTML_MODE_LEGACY));
        }

        if (this.overlayList.get(position_fixed).getType1c() == null) {
            String metadata = Packages.getOverlayMetadata(
                    context,
                    packageName,
                    References.metadataOverlayType1c);
            if (metadata != null && !metadata.isEmpty()) {
                metadata = metadata.replace("_", " ");
                final String textView = "<b>" + context.getString(R.string.manager_type1c) +
                        "</b> " + metadata;
                viewHolder.type1c.setVisibility(View.VISIBLE);
                this.overlayList.get(position_fixed).setType1c(textView);
                viewHolder.type1c.setText(Html.fromHtml(textView, FROM_HTML_MODE_LEGACY));
            } else {
                viewHolder.type1c.setVisibility(View.GONE);
            }
        } else {
            viewHolder.type1c.setVisibility(View.VISIBLE);
            viewHolder.type1c.setText(Html.fromHtml(this.overlayList.get(position_fixed).getType1c(),
                    FROM_HTML_MODE_LEGACY));
        }

        if (this.overlayList.get(position_fixed).getType2() == null) {
            String metadata = Packages.getOverlayMetadata(
                    context,
                    packageName,
                    References.metadataOverlayType2);
            if (metadata != null && !metadata.isEmpty()) {
                metadata = metadata.replace("_", " ");
                final String textView = "<b>" + context.getString(R.string.manager_type2) +
                        "</b> " + metadata;
                viewHolder.type2.setVisibility(View.VISIBLE);
                this.overlayList.get(position_fixed).setType2(textView);
                viewHolder.type2.setText(Html.fromHtml(textView, FROM_HTML_MODE_LEGACY));
            } else {
                viewHolder.type2.setVisibility(View.GONE);
            }
        } else {
            viewHolder.type2.setVisibility(View.VISIBLE);
            viewHolder.type2.setText(Html.fromHtml(this.overlayList.get(position_fixed).getType2(),
                    FROM_HTML_MODE_LEGACY));
        }

        if (this.overlayList.get(position_fixed).getType3() == null) {
            String metadata = Packages.getOverlayMetadata(
                    context,
                    packageName,
                    References.metadataOverlayType3);
            if (metadata != null && !metadata.isEmpty()) {
                metadata = metadata.replace("_", " ");
                final String textView = "<b>" + context.getString(R.string.manager_type3) +
                        "</b> " + metadata;
                viewHolder.type3.setVisibility(View.VISIBLE);
                this.overlayList.get(position_fixed).setType3(textView);
                viewHolder.type3.setText(Html.fromHtml(textView, FROM_HTML_MODE_LEGACY));
            } else {
                viewHolder.type3.setVisibility(View.GONE);
            }
        } else {
            viewHolder.type3.setVisibility(View.VISIBLE);
            viewHolder.type3.setText(Html.fromHtml(this.overlayList.get(position_fixed).getType3(),
                    FROM_HTML_MODE_LEGACY));
        }

        if (this.overlayList.get(position_fixed).getType4() == null) {
            String metadata = Packages.getOverlayMetadata(
                    context,
                    packageName,
                    References.metadataOverlayType4);
            if (metadata != null && !metadata.isEmpty()) {
                metadata = metadata.replace("_", " ");
                final String textView = "<b>" + context.getString(R.string.manager_type4) +
                        "</b> " + metadata;
                viewHolder.type4.setVisibility(View.VISIBLE);
                this.overlayList.get(position_fixed).setType4(textView);
                viewHolder.type4.setText(Html.fromHtml(textView, FROM_HTML_MODE_LEGACY));
            } else {
                viewHolder.type4.setVisibility(View.GONE);
            }
        } else {
            viewHolder.type4.setVisibility(View.VISIBLE);
            viewHolder.type4.setText(Html.fromHtml(this.overlayList.get(position_fixed).getType4(),
                    FROM_HTML_MODE_LEGACY));
        }

        final String textView = "<b>" + context.getString(R.string.manager_version) +
                "</b> " +
                String.valueOf(
                        Packages.getOverlaySubstratumVersion(
                                context,
                                this.overlayList.get(position_fixed)
                                        .getName()));
        viewHolder.version.setText(Html.fromHtml(textView, FROM_HTML_MODE_LEGACY));

        if (this.overlayList.get(position_fixed).getThemeName().isEmpty()) {
            viewHolder.tvDesc.setText(packageName);
        } else {
            viewHolder.tvDesc.setText(
                    Html.fromHtml(this.overlayList.get(position_fixed).getThemeName(),
                            FROM_HTML_MODE_LEGACY));
        }

        viewHolder.chkSelected.setChecked(this.overlayList.get(position_fixed).isSelected());
        viewHolder.chkSelected.setTag(this.overlayList.get(position_fixed));
        viewHolder.chkSelected.setOnClickListener(view -> {
            final CheckBox checkBox = (CheckBox) view;
            final ManagerItem contact = (ManagerItem) checkBox.getTag();

            contact.setSelected(checkBox.isChecked());
            this.overlayList.get(position_fixed).setSelected(checkBox.isChecked());
        });
        viewHolder.card.setOnClickListener(view -> {
            viewHolder.chkSelected.setChecked(!viewHolder.chkSelected.isChecked());

            final CheckBox cb = viewHolder.chkSelected;
            final ManagerItem contact = (ManagerItem) cb.getTag();

            contact.setSelected(cb.isChecked());
            contact.setSelected(cb.isChecked());
        });
        if (this.overlayList.get(position_fixed).getDrawable() == null) {
            final Drawable app_icon = Packages.getAppIcon(
                    this.overlayList.get(position_fixed).getContext(),
                    Packages.getOverlayParent(
                            this.overlayList.get(position_fixed).getContext(),
                            this.overlayList.get(position_fixed).getName()));
            this.overlayList.get(position_fixed).setDrawable(app_icon);
            viewHolder.appIcon.setImageDrawable(app_icon);
        } else {
            viewHolder.appIcon.setImageDrawable(this.overlayList.get(position_fixed).getDrawable());
        }
        if (this.overlayList.get(position_fixed).getTargetDrawable() == null) {
            final Drawable app_icon = Packages.getAppIcon(
                    this.overlayList.get(position_fixed).getContext(),
                    Packages.getOverlayTarget(
                            this.overlayList.get(position_fixed).getContext(),
                            this.overlayList.get(position_fixed).getName()));
            this.overlayList.get(position_fixed).setTargetDrawable(app_icon);
            viewHolder.appIconTarget.setImageDrawable(app_icon);
        } else {
            viewHolder.appIconTarget.setImageDrawable(
                    this.overlayList.get(position_fixed).getTargetDrawable());
        }
    }

    @Override
    public int getItemCount() {
        return this.overlayList.size();
    }

    public List<ManagerItem> getOverlayManagerList() {
        return this.overlayList;
    }

    public void setOverlayManagerList(final List<ManagerItem> overlayList) {
        this.overlayList = overlayList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        CheckBox chkSelected;
        CardView card;
        ImageView appIcon;
        ImageView appIconTarget;
        TextView type1a;
        TextView type1b;
        TextView type1c;
        TextView type2;
        TextView type3;
        TextView type4;
        TextView version;

        ViewHolder(final View itemLayoutView) {
            super(itemLayoutView);
            this.tvName = itemLayoutView.findViewById(R.id.tvName);
            this.tvDesc = itemLayoutView.findViewById(R.id.desc);
            this.card = itemLayoutView.findViewById(R.id.overlayCard);
            this.chkSelected = itemLayoutView.findViewById(R.id.chkSelected);
            this.appIcon = itemLayoutView.findViewById(R.id.app_icon);
            this.appIconTarget = itemLayoutView.findViewById(R.id.app_icon_sub);
            this.type1a = itemLayoutView.findViewById(R.id.type1a);
            this.type1b = itemLayoutView.findViewById(R.id.type1b);
            this.type1c = itemLayoutView.findViewById(R.id.type1c);
            this.type2 = itemLayoutView.findViewById(R.id.type2);
            this.type3 = itemLayoutView.findViewById(R.id.type3);
            this.type4 = itemLayoutView.findViewById(R.id.type4);
            this.version = itemLayoutView.findViewById(R.id.version);
        }
    }
}