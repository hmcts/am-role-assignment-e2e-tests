locals {
  app_full_name = join("-", [var.product, var.component])

  local_env = (var.env == "preview" || var.env == "spreview") ? (var.env == "preview" ) ? "aat" : "saat" : var.env

  // Vault name
  previewVaultName = join("-", [var.raw_product, "aat"])
  nonPreviewVaultName = join("-", [var.raw_product, var.env])
  vaultName = (var.env == "preview" || var.env == "spreview") ? local.previewVaultName : local.nonPreviewVaultName

  // Shared Resource Group
  previewResourceGroup = join("-", [var.raw_product, "shared-infrastructure-aat"])
  nonPreviewResourceGroup = join("-", [var.raw_product, "shared-infrastructure", var.env])
  sharedResourceGroup = (var.env == "preview" || var.env == "spreview") ? local.previewResourceGroup : local.nonPreviewResourceGroup
}

data "azurerm_key_vault" "am_key_vault" {
  name                = local.vaultName
  resource_group_name = local.sharedResourceGroup
}
