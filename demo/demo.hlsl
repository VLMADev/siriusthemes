// === Структуры ===
struct VSInput {
    float4 position : POSITION;
    float4 color : COLOR0;
};

struct VSOutput {
    float4 position : SV_POSITION;
    float4 color : COLOR0;
};

// === Параметры ===
cbuffer Constants : register(b0) {
    float4x4 modelViewProj;
};

// === Текстуры и Sampler ===
Texture2D baseMap : register(t0);
SamplerState samLinear : register(s0);

// === Вершинный шейдер ===
VSOutput VSMain(VSInput input) {
    VSOutput output;
    output.position = mul(modelViewProj, input.position);
    output.color = input.color;
    return output;
}

// === Пиксельный шейдер ===
float4 PSMain(VSOutput input) : SV_Target {
    float4 baseColor = baseMap.Sample(samLinear, input.texCoord);
    return baseColor * input.color;
}