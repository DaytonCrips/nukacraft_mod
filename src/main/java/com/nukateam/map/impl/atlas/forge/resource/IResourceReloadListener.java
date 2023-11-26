package com.nukateam.map.impl.atlas.forge.resource;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * @author Stereowalker
 * @param <T>
 */
@SuppressWarnings("deprecation")

public interface IResourceReloadListener<T> extends ResourceManagerReloadListener {

	@Override
	default void onResourceManagerReload(
			ResourceManager resourceManager/* , Predicate<IResourceType> resourcePredicate */) {
		
	}
	
	@Override
	default CompletableFuture<Void> reload(PreparationBarrier stage, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
		return load(resourceManager, preparationsProfiler, backgroundExecutor)
				.thenCompose(stage::wait)
				.thenAccept((value) -> {
						apply(value, resourceManager, reloadProfiler, gameExecutor);
				});

	}

	CompletableFuture<T> load(ResourceManager resourceManager, ProfilerFiller profiler, Executor executor);

	CompletableFuture<Void> apply (T value, ResourceManager resourceManager, ProfilerFiller profiler, Executor executor);

	default ResourceLocation getForgeId() {
		return null;
	}

	default Collection<ResourceLocation> getForgeDependencies() {
		return null;
	}
}
