/*
 * Deferred light shader variant: directional, linear depth g-buffer, shadows
 */

// Directional light
#define LIGHT_VARIANT_TYPE_POINT 0
#define LIGHT_VARIANT_TYPE_SPOT 0
#define LIGHT_VARIANT_TYPE_DIRECTIONAL 1

// Linear depth in g-buffer
#define LIGHT_VARIANT_LINEAR_DEPTH 1

// Shadows w/ depth packing, 4 cascades
#define LIGHT_VARIANT_SHADOW_PACK 1
#define LIGHT_VARIANT_SHADOW_SAMPLE 0
#define LIGHT_VARIANT_SHADOW_CSM 4
#define LIGHT_VARIANT_SHADOW_SOFT 0

#include "./fs_deferred_light_common.sh"